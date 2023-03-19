package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2023-03-14
 */
public class Solution1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1605 solution1605 = new Solution1605();
        int[] rowSum = {14,9};
        int[] colSum = {6,9,8};
        System.out.println(Arrays.deepToString(solution1605.restoreMatrix(rowSum, colSum)));
    }
}
