package com.dengwn.leetcode.solution.t3.h1.d1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author dengwenning
 * @since 2024/8/16
 **/
public class Solution3117 {
    int[] nums;
    int[] andValues;
    int max = Integer.MAX_VALUE / 2;
    HashMap<Long, Integer> memo = new HashMap<>();

    public int minimumValueSum(int[] nums, int[] andValues) {
        this.nums = nums;
        this.andValues = andValues;
        int dfs = dfs(0, 0, -1);
        return dfs == max ? -1 : dfs;
    }

    public int dfs(int i, int j, int pre) {
        if (nums.length - i < andValues.length - j) {
            return max;
        }
        if (j == andValues.length && i < nums.length) {
            return max;
        }
        if (j == andValues.length && i == nums.length) {
            return 0;
        }

        pre &= nums[i];
        if (pre < andValues[j]) {
            return max;
        }
        long key = (long) i << 36 | (long) j << 32 | pre;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = dfs(i + 1, j, pre);
        if (pre == andValues[j]) {
            // 能划分
            res = Math.min(res, dfs(i + 1, j + 1, -1) + nums[i]);
        }
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        Solution3117 solution3117 = new Solution3117();

        int[] nums = {1, 4, 3, 3, 2};
        int[] andValues = {0, 3, 3, 2};
        System.out.println(solution3117.minimumValueSum(nums, andValues));
    }
}
