package com.dengwn.code.leetcode.solution.t2.h7.d8;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/10/23
 **/
public class Solution2787 {
    static final int MODULO = 1000000007;
    int x;
    long[][] memo;

    public int numberOfWays(int n, int x) {
        int mx = 0;
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            mx = i;
        }
        this.memo = new long[n + 1][mx + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        this.x = x;
        return (int) (dfs(n, mx) % MODULO);
    }

    public long dfs(int n, int mx) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (memo[n][mx] != -1) {
            return memo[n][mx];
        }
        long ans = 0;
        for (int i = mx; i > 0; i--) {
            int pow = (int) Math.pow(i, x);
            ans += dfs(n - pow, i - 1);
        }
        return memo[n][mx] = ans;
    }

    public int numberOfWays1(int n, int x) {
        int maxNum = (int) Math.pow(n + 0.5, 1.0 / x);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= maxNum; i++) {
            int power = (int) Math.pow(i, x);
            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j - power]) % MODULO;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution2787 solution2787 = new Solution2787();
        System.out.println(solution2787.numberOfWays(10, 2));
    }
}
