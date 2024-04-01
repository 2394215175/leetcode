package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2024-04-01
 **/
public class Solution2266 {
    int MOD = (int) 1e9 + 7;
    int[] table = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int cnt = 0;
        long ans = 1;
        for (int i = 0; i < n; i++) {
            cnt++;
            char c = pressedKeys.charAt(i);
            if (i == n - 1 || c != pressedKeys.charAt(i + 1)) {
                ans *= f(cnt, c - '0');
                ans %= MOD;
                cnt = 0;
            }
        }
        return (int) ans;
    }

    public int f(int n, int c) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, table[c]); j++) {
                dp[i] += dp[i - j];
                dp[i] %= MOD;
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        Solution2266 solution2266 = new Solution2266();
        System.out.println(solution2266.countTexts("22233"));

//        System.out.println(solution2266.f(3, '2'-'0'));
    }
}
