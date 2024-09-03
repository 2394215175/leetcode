package com.dengwn.leetcode.solution.t0.h0.d3;

/**
 * @author dengwenning
 * @since 2024/8/23
 **/
public class Solution32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int[] dp = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            dp[i] = dp[i - 1] + (array[i - 1] == '(' ? 1 : -1);
        }
        int ans = 0;
        int prev = 0;
        return 0;
    }
}
