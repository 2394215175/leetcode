package com.dengwn.leetcode.solution.t2.h8.d8;

/**
 * @author dengwenning
 * @since 2024/6/18
 **/
public class Solution2088 {
    public int countPyramids(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        // 从两层开始
        // 两层正金字塔
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 1 && grid[i + 1][j - 1] == 1 && grid[i + 1][j] == 1 && grid[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
