package com.dengwn.leetcode.solution.t1.h2;

/**
 * @author: dengwn
 * @date: 2023-08-10
 **/
public class Solution1289 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        System.arraycopy(grid[0], 0, d[0], 0, n);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    d[i][j] = Math.min(d[i][j], d[i - 1][k] + grid[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, d[n - 1][j]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1289 solution1289 = new Solution1289();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution1289.minFallingPathSum(grid));
    }
}
