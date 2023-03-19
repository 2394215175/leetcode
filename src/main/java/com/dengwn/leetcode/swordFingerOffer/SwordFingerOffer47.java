package com.dengwn.leetcode.swordFingerOffer;

/**
 * @author dengwn
 * @date: 2023-03-08
 */
public class SwordFingerOffer47 {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1][m - 1];
    }

    public int maxValue1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                }
                if (j > 0) {
                    f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                }
                f[i][j] += grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        SwordFingerOffer47 swordFingerOffer47 = new SwordFingerOffer47();
        System.out.println(swordFingerOffer47.maxValue(grid));
        System.out.println(swordFingerOffer47.maxValue1(grid));
    }
}
