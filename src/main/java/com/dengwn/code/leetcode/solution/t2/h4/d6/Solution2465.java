package com.dengwn.code.leetcode.solution.t2.h4.d6;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2023-06-04
 */
public class Solution2465 {
    public int distinctAverages(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] cnt = new int[201];
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            if (++cnt[nums[i] + nums[n - i - 1]] == 1){
                ans++;
            }
        }
        return ans;
    }
}
