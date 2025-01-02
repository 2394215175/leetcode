package com.dengwn.code.leetcode.solution.t0.h3.d4;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-02-14
 **/
public class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
