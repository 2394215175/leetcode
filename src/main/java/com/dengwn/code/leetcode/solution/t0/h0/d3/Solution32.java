package com.dengwn.code.leetcode.solution.t0.h0.d3;

/**
 * @author dengwenning
 * @since 2024/8/23
 **/
public class Solution32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] == '(') {
                continue;
            }
            if (array[i - 1] == '(') {
                dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
            } else if (i - dp[i - 1] - 1 >= 0 && array[i - dp[i - 1] - 1] == '(') {
                dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses("(()())"));
    }
}
