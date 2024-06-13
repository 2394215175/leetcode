package com.dengwn.leetcode.solution.t0.h0.d6;

/**
 * @author: dengwn
 * @date: 2023-02-09
 **/
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] steps = new int[m][n];
        for (int i = 0; i < n - 1; i++) {
            steps[m - 1][n] = 1;
        }
        for (int i = 0; i < m - 1; i++) {
            steps[i][n - 1] = 1;
        }
        steps[m - 1][n - 1] = 0;

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                steps[i][j] = steps[i + 1][j] + steps[i][j + 1];
            }
        }
        return steps[0][0];
    }
}
