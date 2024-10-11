package com.dengwn.leetcode.solution.t2.h0.d8;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/9/26
 **/
public class Solution2088 {
    public int countPyramids(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int ans = 0;
        // 正向遍历，倒金字塔
        for (int j = 0; j < m; j++) {
            dp[n - 1][j] = grid[n - 1][j] - 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = -1;
                } else {
                    int left = j - 1 < 0 ? -1 : dp[i + 1][j - 1];
                    int right = j + 1 >= m ? -1 : dp[i + 1][j + 1];
                    dp[i][j] = Math.min(Math.min(left, right), dp[i + 1][j]) + 1;
                    ans += dp[i][j];
                }
            }
        }

        for (int j = 0; j < m; j++) {
            dp[0][j] = grid[0][j] - 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = -1;
                } else {
                    int left = j - 1 < 0 ? -1 : dp[i - 1][j - 1];
                    int right = j + 1 >= m ? -1 : dp[i - 1][j + 1];
                    dp[i][j] = Math.min(Math.min(left, right), dp[i - 1][j]) + 1;
                    ans += dp[i][j];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1}};
        Solution2088 solution2088 = new Solution2088();
        System.out.println(solution2088.countPyramids(grid));

    }
}
