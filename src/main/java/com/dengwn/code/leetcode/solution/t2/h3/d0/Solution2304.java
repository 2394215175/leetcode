package com.dengwn.code.leetcode.solution.t2.h3.d0;

/**
 *
 * @author dengwenning
 * @since 2024/11/15
 **/
public class Solution2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        System.arraycopy(grid[0], 0, dp[0], 0, m);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int cur = grid[i][j];
                int[] next = moveCost[cur];
                for (int k = 0; k < m; k++) {
                    dp[i + 1][k] = Math.min(dp[i + 1][k], dp[i][j] + next[k]);
                }
            }
            for (int j = 0; j < m; j++) {
                dp[i + 1][j] += grid[i + 1][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{5, 1, 2}, {4, 0, 3}};
        int[][] moveCost = {{12, 10, 15}, {20, 23, 8}, {21, 7, 1}, {8, 1, 13}, {9, 10, 25}, {5, 3, 2}};
        Solution2304 solution2304 = new Solution2304();
        System.out.println(solution2304.minPathCost(grid, moveCost));

    }
}
