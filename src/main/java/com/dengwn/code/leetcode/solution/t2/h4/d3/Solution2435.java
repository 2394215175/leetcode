package com.dengwn.code.leetcode.solution.t2.h4.d3;

/**
 *
 * @author dengwenning
 * @since 2024/10/23
 **/
public class Solution2435 {
    public int numberOfPaths(int[][] grid, int k) {
        int MOD = (int) 1e9 + 7;
        int n = grid.length;
        int m = grid[0].length;
        long[][][] dp = new long[n][m][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][0][(grid[i][0] + j) % k] = dp[i - 1][0][j];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < k; j++) {
                dp[0][i][(grid[0][i] + j) % k] = dp[0][i - 1][j];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    int mod = grid[i][j] % k;
                    dp[i][j][l] = dp[i - 1][j][(l + k - mod) % k] + dp[i][j - 1][(l + k - mod) % k];
                    dp[i][j][l] %= MOD;
                }
            }
        }
        return (int) (dp[n - 1][m - 1][0] % MOD);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {5, 2, 4},
                {3, 0, 5},
                {0, 7, 2}};
        int k = 3;
        Solution2435 solution2435 = new Solution2435();
        System.out.println(solution2435.numberOfPaths(grid, k));
    }
}
