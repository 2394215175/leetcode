package com.dengwn.code.leetcode.solution.t0.h5.d0;

/**
 * @author: dengwn
 * @date: 2022-12-23
 **/
public class Solution509 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
