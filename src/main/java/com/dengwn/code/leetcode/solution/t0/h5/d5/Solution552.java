package com.dengwn.code.leetcode.solution.t0.h5.d5;

/**
 * @author dengwenning
 * @since 2024/8/19
 **/
public class Solution552 {
    /**
     * 'A'：Absent，缺勤
     * 'L'：Late，迟到
     * 'P'：Present，到场
     */
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        // 第二位表示当前多少个A
        // 第三位表示之前多少个连续的L
        long[][] dp = new long[2][3];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            long[][] temp = new long[2][3];

            // 当前为 P
            temp[0][0] = (dp[0][0] + dp[0][1] + dp[0][2]) % MOD;
            temp[1][0] = (dp[1][0] + dp[1][1] + dp[1][2] + dp[0][0] + dp[0][1] + dp[0][2]) % MOD;

            // 当前为 L
            temp[0][1] = dp[0][0] % MOD;
            temp[0][2] = dp[0][1] % MOD;
            temp[1][1] = dp[1][0] % MOD;
            temp[1][2] = dp[1][1] % MOD;

            dp = temp;
        }

        return (int)((dp[0][0] + dp[0][1] + dp[0][2] + dp[1][0] + dp[1][1] + dp[1][2]) % MOD);
    }

    public static void main(String[] args) {
        Solution552 solution552 = new Solution552();
        System.out.println(solution552.checkRecord(10101));
    }
}
