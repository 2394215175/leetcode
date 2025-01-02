package com.dengwn.code.leetcode.solution.t0.h2.d4;

/**
 *
 * @author dengwenning
 * @since 2024/12/16
 **/
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            int cur = matrix[i][j];
            if (cur == target) {
                return true;
            }
            if (cur < target) {
                i++;
            }
            if (cur > target) {
                j--;
            }
        }
        return false;
    }
}
