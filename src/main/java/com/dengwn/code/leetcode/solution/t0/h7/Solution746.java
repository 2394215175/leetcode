package com.dengwn.code.leetcode.solution.t0.h7;

/**
 * @author: dengwn
 * @date: 2022-12-23
 **/
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length + 1;
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len - 1];
    }
}
