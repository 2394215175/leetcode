package com.dengwn.code.leetcode.solution.t0.h3.d7;

/**
 * @author: dengwn
 * @date: 2024-04-01
 **/
public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
