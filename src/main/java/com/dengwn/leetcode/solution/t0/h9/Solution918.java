package com.dengwn.leetcode.solution.t0.h9;

/**
 * @author: dengwn
 * @date: 2023-01-12
 **/
public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int dp = nums[0];
        int sum = nums[0];
        int max = nums[0];
        int min = 0;

        for (int i = 1; i < n; i++) {
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(dp, max);
            sum += nums[i];
        }

        dp = nums[0];
        for (int i = 1; i < n - 1; i++) {
            dp = nums[i] + Math.min(0, dp);
            min = Math.min(dp, min);
        }

        return Math.max(sum - min, max);
    }
}
