package com.dengwn.leetcode.solution.t0.h0.d0;

/**
 * @author: dengwn
 * @date: 2023-02-10
 **/
public class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;

        }

        for (int left = 2; left <= n; left++) {
            for (int i = 0; i < n - left + 1; i++) {
                int j = left + i - 1;

                if (chars[i] == chars[j]) {
                    dp[i][j] = j - i < 3 || dp[i + 1][j - 1];
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("aaaa"));
    }
}
