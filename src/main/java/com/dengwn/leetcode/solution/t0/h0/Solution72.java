package com.dengwn.leetcode.solution.t0.h0;

/**
 * @author: dengwn
 * @date: 2023-02-15
 **/
public class Solution72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i][j - 1];
                int down = dp[i - 1][j];
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i) == word2.charAt(j)) {
                    leftDown--;
                }
                dp[i][j] = Math.min(leftDown, Math.min(left, down)) + 1;
            }
        }
        return dp[n][m];
    }
}
