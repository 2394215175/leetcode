package com.dengwn.code.leetcode.solution.t0.h6.d8;

/**
 *
 * @author dengwenning
 * @since 2024/12/8
 **/
public class Solution688 {

    int[][] dis = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    double[][][] memo;
    int N;
    int K;

    public double knightProbability(int n, int k, int row, int column) {
        memo = new double[n][n][k + 1];
        N = n;
        K = k;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l <= k; l++) {
                    memo[i][j][l] = -1;
                }
            }
        }
        return dfs(row, column, 0);
    }

    public double dfs(int r, int c, int t) {
        if(r < 0 || r >= N || c < 0 || c >= N){
            return 0;
        }
        if (memo[r][c][t] != -1) {
            return memo[r][c][t];
        }
        if (t == K) {
            return Math.pow(1.0 / 8, t);
        }
        double ans = 0;
        for (int[] d : dis) {
            int nr = r + d[0];
            int nc = c + d[1];
            ans += dfs(nr, nc, t + 1);
        }
        return memo[r][c][t] = ans;
    }

    public static void main(String[] args) {
        Solution688 solution688 = new Solution688();
        System.out.println(solution688.knightProbability(3, 2, 0, 0));
    }

}
