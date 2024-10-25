package com.dengwn.code.leetcode.solution.t0.h0.d7;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-11-22
 **/
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean r0 = false;
        boolean c0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                r0 = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                c0 = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }


        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        if (r0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (c0) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
