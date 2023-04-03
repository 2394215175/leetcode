package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-03-31
 **/
public class Solution1901 {
    public int[] findPeakGrid(int[][] mat) {
        int j = 0;
        int max = 0;
        int left = 0;
        int right = mat.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            for (int i = 0; i < mat[mid].length; i++) {
                if (mat[mid][i] > max) {
                    j = i;
                    max = mat[mid][i];
                }
            }
            if (mid > 0 && mat[mid - 1][j] > mat[mid][j]) {
                right = mid - 1;
            } else if (mid < mat.length - 1 && mat[mid + 1][j] > mat[mid][j]) {
                left = mid + 1;
            } else {
                return new int[]{mid, j};
            }
        }
        return new int[]{left, j};
    }

    public static void main(String[] args) {
        int[][] mat = {{10, 40, 41}, {21, 30, 14}, {7, 16, 32}};
        Solution1901 solution1901 = new Solution1901();
        System.out.println(Arrays.toString(solution1901.findPeakGrid(mat)));
    }
}
