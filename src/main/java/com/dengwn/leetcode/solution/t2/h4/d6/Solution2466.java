package com.dengwn.leetcode.solution.t2.h4.d6;

/**
 * @author: dengwn
 * @date: 2024-04-01
 **/
public class Solution2466 {
    final int MOD = (int) 1e9 + 7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
                dp[i] %= MOD;
            }
            if (i >= one) {
                dp[i] += dp[i - one];
                dp[i] %= MOD;
            }
            if (i >= low) {
                ans += dp[i];
                ans %= MOD;
            }
        }
        return ans;
    }

}
