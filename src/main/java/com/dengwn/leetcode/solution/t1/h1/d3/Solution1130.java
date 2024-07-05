package com.dengwn.leetcode.solution.t1.h1.d3;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-05-31
 **/
public class Solution1130 {
    int INF = 0x3F3F3F3F;
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        int[][] mval = new int[n][n];
        for (int j = 0; j < n; j++) {
            mval[j][j] = arr[j];
            dp[j][j] = 0;
            for (int i = j - 1; i >= 0; i--) {
                mval[i][j] = Math.max(arr[i], mval[i + 1][j]);
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + mval[i][k] * mval[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution1130 solution1130 = new Solution1130();
        int[] arr = {6, 2, 4};
        System.out.println(solution1130.mctFromLeafValues(arr));
    }
}
