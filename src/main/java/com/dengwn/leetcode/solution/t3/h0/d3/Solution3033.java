package com.dengwn.leetcode.solution.t3.h0.d3;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/7/5
 **/
public class Solution3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int j = 0; j < m; j++) {
            int max = -1;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, -1}, {4, -1, 6}, {7, 8, 9}};
        Solution3033 solution3033 = new Solution3033();
        System.out.println(Arrays.deepToString(solution3033.modifiedMatrix(matrix)));
    }
}
