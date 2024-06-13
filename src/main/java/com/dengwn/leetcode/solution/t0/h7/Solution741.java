package com.dengwn.leetcode.solution.t0.h7;

/**
 * @author dengwenning
 * @since 2024/5/6
 **/
public class Solution741 {


    public int cherryPickup(int[][] grid) {
//        int n = grid.length;
//        int[][][] dp = new int[2 * n - 1][n][n];
//        for (int i = 0; i < 2 * n - 1; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    dp[i][j][k] = Integer.MIN_VALUE;
//                }
//            }
//        }
//        dp[0][0][0] = grid[0][0];
//        // 从0开始
//        for (int k = 1; k < 2 * n - 1; k++) {
//            for (int x1 = Math.max(k - n + 1, 0); x1 <= Math.min(k, n - 1); x1++) {
//                if (grid[x1][k - x1] == -1) {
//                    continue;
//                }
//                for (int x2 = x1; x2 <= Math.min(k, n - 1); x2++) {
//                    if (grid[x2][k - x2] == -1) {
//                        continue;
//                    }
//                    int res = dp[k - 1][x1][x2];
//                    if (x1 > 0) {
//                        res = Math.max(res, dp[k - 1][x1 - 1][x2]);
//                    }
//                    if (x2 > 0) {
//                        res = Math.max(res, dp[k - 1][x1][x2 - 1]);
//                    }
//                    if (x1 > 0 && x2 > 0) {
//                        res = Math.max(res, dp[k - 1][x1 - 1][x2 - 1]);
//
//                    }
//                    res += grid[x1][k - x1];
//                    if (x1 != x2) {
//                        res += grid[x2][k - x2];
//                    }
//                    dp[k][x1][x2] = res;
//                }
//            }
//        }
//
//        return Math.max(dp[2 * (n - 1)][n - 1][n - 1], 0);


        int n = grid.length;
        int[][][] f = new int[2 * n + 1][n + 1][n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    f[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        f[2][1][1] = grid[0][0];
        for (int k = 3; k < 2 * n + 1; k++) {
            for (int x1 = 1; x1 < n + 1; x1++) {
                for (int x2 = 1; x2 < n + 1; x2++) {
                    int y1 = k - x1;
                    int y2 = k - x2;
                    if (y1 <= 0 || y1 > n || y2 <= 0 || y2 > n) {
                        continue;
                    }

                    int A = grid[x1 - 1][y1 - 1];
                    int B = grid[x2 - 1][y2 - 1];
                    if (A == -1 || B == -1) {
                        continue;
                    }

                    int a = f[k - 1][x1][x2];
                    int b = f[k - 1][x1 - 1][x2];
                    int c = f[k - 1][x1][x2 - 1];
                    int d = f[k - 1][x1 - 1][x2 - 1];
                    int res = Math.max(Math.max(a, b), Math.max(c, d)) + A;
                    if (x1 != x2) {
                        res += B;
                    }
                    f[k][x1][x2] = res;

                }
            }
        }
        return Math.max(f[2 * n][n][n], 0);
    }


    public static void main(String[] args) {
        Solution741 solution741 = new Solution741();
        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        System.out.println(solution741.cherryPickup(grid));

    }
}
