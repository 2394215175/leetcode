package com.dengwn.leetcode.solution.t1.h5;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    ans += mat[i][j];
                }
            }
        }
        return n % 2 == 0 ? ans : ans - mat[n / 2][n / 2];
    }
}
