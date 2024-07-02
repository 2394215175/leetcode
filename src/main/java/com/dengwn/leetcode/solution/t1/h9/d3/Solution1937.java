package com.dengwn.leetcode.solution.t1.h9.d3;

/**
 * @author dengwenning
 * @since 2024/6/29
 **/
public class Solution1937 {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[][] dp = new long[n + 1][m];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i + 1][j] = Math.max(dp[i][k] + points[i][j] - Math.abs(k - j), dp[i + 1][j]);
                }
            }
        }

        return ans;

    }
}
