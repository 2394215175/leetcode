package com.dengwn.leetcode.solution.t1.h4;

/**
 * @author dengwenning
 * @since 2024/5/7
 **/
public class Solution1463 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];
        dp[0][m - 1][0] = grid[0][0] + grid[0][m - 1];

        for (int x = 1; x < n; x++) {
            for (int y1 = 0; y1 <= Math.min(x, m - 1); y1++) {
                int y2 = m - 1;
                while (y2 >= Math.max(m - 1 - x, 0)) {
                    // 从9个地方转移过来
                    int res = 0;
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (y1 + i > m - 1 || y1 + i < 0 || y2 + j > m - 1 || y2 + j < 0) {
                                y2--;
                                continue;
                            }
                            res = Math.max(res, dp[x - 1][y1 + i][y2 + j]);
                        }
                    }

                    dp[x][y1][y2] = res + grid[x][y1];
                    if (y1 != y2) {
                        dp[x][y1][y2] += grid[x][y2];
                    }
                    y2--;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[n - 1][i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1463 solution1463 = new Solution1463();
//        int[][] grid = {{0, 8, 7, 10, 9, 10, 0, 9, 6},
//                {8, 7, 10, 8, 7, 4, 9, 6, 10},
//                {8, 1, 1, 5, 1, 5, 5, 1, 2},
//                {9, 4, 10, 8, 8, 1, 9, 5, 0},
//                {4, 3, 6, 10, 9, 2, 4, 8, 10},
//                {7, 3, 2, 8, 3, 3, 5, 9, 8},
//                {1, 2, 6, 5, 6, 2, 0, 10, 0}};
        int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        System.out.println(solution1463.cherryPickup(grid));
    }
}
