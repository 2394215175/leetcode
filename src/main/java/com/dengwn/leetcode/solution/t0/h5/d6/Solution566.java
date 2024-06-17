package com.dengwn.leetcode.solution.t0.h5.d6;

/**
 * @author: dengwn
 * @date: 2022-12-29
 **/
public class Solution566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if (n * m != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            res[x / c][x % c] = mat[x / n][x % n];
        }

        return res;
    }
}
