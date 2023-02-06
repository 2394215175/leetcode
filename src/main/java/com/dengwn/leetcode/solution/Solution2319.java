package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-31
 **/
public class Solution2319 {
    public boolean checkXMatrix(int[][] grid) {
        int m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j || i + j == m) {
                    if(grid[i][j] == 0){
                        return false;
                    }
                } else {
                    if(grid[i][j] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{5, 0, 0, 1}, {0, 4, 1, 5}, {0, 5, 2, 0}, {4, 1, 0, 2}};
        Solution2319 solution2319 = new Solution2319();
        System.out.println(solution2319.checkXMatrix(grid));
    }
}
