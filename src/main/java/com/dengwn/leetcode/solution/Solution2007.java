package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2024-04-18
 **/
public class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            return new int[0];
        }
        int[] nums = new int[200001];
        for (int i : changed) {
            nums[i]++;
        }

        // 单独处理 0
        if (nums[0] % 2 == 1) {
            return new int[0];
        }
        int[] ans = new int[n / 2];
        int ansIdx = nums[0] / 2;

        for (int i = 1; i < 100001; i++) {
            int cntI = nums[i];
            if (cntI == 0) {
                continue;
            }
            if (nums[i * 2] < cntI) {
                return new int[0];
            }
            for (int j = 0; j < cntI; j++) {
                ans[ansIdx++] = i;
            }
            nums[i * 2] -= cntI;
            if (i > 50000 && nums[i * 2] > 0) {
                return new int[0];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2007 solution2007 = new Solution2007();
        System.out.println(Arrays.toString(solution2007.findOriginalArray(new int[]{3, 3, 3, 3})));
    }
}
