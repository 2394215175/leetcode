package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-12-01
 **/
public class Solution790 {
    static final int MOD = 1000000007;

    public int numTilings(int n) {
        long[] dp = new long[1001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        Solution790 solution790 = new Solution790();
        System.out.println(solution790.numTilings(30));
    }

}
