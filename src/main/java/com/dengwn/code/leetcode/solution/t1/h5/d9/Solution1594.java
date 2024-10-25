package com.dengwn.code.leetcode.solution.t1.h5.d9;

import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/10/21
 **/
public class Solution1594 {
    public int maxProductPath(int[][] grid) {
        final int MOD = 1000000000 + 7;
        int n = grid.length;
        int m = grid[0].length;
        long[][][] dp = new long[n][m][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = dp[i][0][1] = dp[i - 1][0][0] * grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j - 1][0] * grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 负数最大
                long max = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]);
                long min = Math.min(dp[i - 1][j][0], dp[i][j - 1][0]);
                if (grid[i][j] < 0) {
                    dp[i][j][0] = max * grid[i][j];
                    dp[i][j][1] = min * grid[i][j];
                } else {
                    dp[i][j][0] = min * grid[i][j];
                    dp[i][j][1] = max * grid[i][j];
                }
            }
        }
        return dp[n - 1][m - 1][1] < 0 ? -1 : (int) (dp[n - 1][m - 1][1] % MOD);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, -2, 1}, {1, -2, 1}, {3, -4, 1}};

        Solution1594 solution1594 = new Solution1594();
        System.out.println(solution1594.maxProductPath(grid));
        System.out.println(919261412 % (int) 1e9 + 7);
    }
}
