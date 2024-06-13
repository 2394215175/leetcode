package com.dengwn.leetcode.solution.t0.h5;

/**
 * @author: dengwn
 * @date: 2023-02-15
 **/
public class Solution583 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution583 nSolution583 = new Solution583();
        System.out.println(nSolution583.minDistance("leetcode", "etco"));
    }
}




