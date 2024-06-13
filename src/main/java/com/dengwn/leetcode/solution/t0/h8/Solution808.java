package com.dengwn.leetcode.solution.t0.h8;

/**
 * @author: dengwn
 * @date: 2022-11-21
 **/
public class Solution808 {
    double[][] dp;
    public double soupServings(int n) {
        if (n > 4450) {
            return 1;
        }
        int ceil = n % 25 == 0 ? n / 25 : n / 25 + 1;
        dp = new double[ceil + 1][ceil + 1];
        double dfs = dfs(ceil, ceil);
        return dfs;
    }

    public double soupServings1(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;
            }
        }
        return dp[n][n];
    }

    public double dfs(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1;
        }
        if (b <= 0) {
            return 0;
        }
        if(dp[a][b] == 0)
        {
            dp[a][b] = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs(a - 2, b - 2) + dfs(a - 1, b - 3));
        }
        return dp[a][b];
    }
}
