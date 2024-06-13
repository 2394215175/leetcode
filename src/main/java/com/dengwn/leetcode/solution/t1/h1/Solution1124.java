package com.dengwn.leetcode.solution.t1.h1;

import java.util.ArrayDeque;

/**
 * @author: dengwn
 * @date: 2023-02-14
 **/
public class Solution1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = hours[i - 1] > 8 ? dp[i - 1] + 1 : dp[i - 1] - 1;
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (dp[j] > dp[i]) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public int longestWPI1(int[] hours) {
        int n = hours.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int s = 0;
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            s -= hours[i - 1] > 8 ? 1 : -1;
            if (s < 0) {
                ans = i;
            } else {
                if (dp[s + 1] > 0) {
                    ans = Math.max(ans, i - dp[s + 1]);
                }
                if (dp[s] == 0) {
                    dp[s] = i;
                }
            }
        }
        return ans;
    }

    public int longestWPI2(int[] hours) {
        int n = hours.length, ans = 0;
        int[] s = new int[n + 1];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (int j = 1; j <= n; ++j) {
            s[j] = s[j - 1] + (hours[j - 1] > 8 ? 1 : -1);
            if (s[j] < s[st.peek()]) {
                st.push(j);
            }
        }
        for (int i = n; i > 0; --i) {
            while (!st.isEmpty() && s[i] > s[st.peek()]) {
                ans = Math.max(ans, i - st.pop());
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution1124 solution1124 = new Solution1124();
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        System.out.println(solution1124.longestWPI2(hours));
    }
}
