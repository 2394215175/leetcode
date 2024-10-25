package com.dengwn.code.leetcode.solution.t2.h6.d3;

/**
 * @author dengwenning
 * @since 2024/4/29
 **/
public class Solution2639 {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, String.valueOf(grid[j][i]).length());
            }
            ans[i] = max;
        }
        return ans;
    }
}
