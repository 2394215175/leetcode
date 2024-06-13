package com.dengwn.leetcode.solution.t0.h4;

/**
 * @author dengwn
 * @date: 2022-12-15
 */
public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans += 4 - 2 * ((i - 1 >= 0 && grid[i - 1][j] == 1 ? 1 : 0) + (j - 1 >= 0 && grid[i][j - 1] == 1 ? 1 : 0));
                }
            }
        }

        return ans;
    }
}
