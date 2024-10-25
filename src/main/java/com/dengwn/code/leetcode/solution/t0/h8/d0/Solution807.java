package com.dengwn.code.leetcode.solution.t0.h8.d0;

/**
 * @author dengwenning
 * @since 2024/7/14
 **/
public class Solution807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] maxRow = new int[n];
        int[] maxCol = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
