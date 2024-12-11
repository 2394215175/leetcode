package com.dengwn.code.leetcode.solution.t0.h9.d3;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/12/10
 **/
public class Solution935 {
    /**
     * 123
     * 456
     * 789
     * #0*
     */
    public int knightDialer(int n) {
        /**
         * 0 -> 4,6
         * 1 -> 6,8
         * 2 -> 7,9
         * 3 -> 4,8
         * 4 -> 3,9,0
         * 5 -> 无
         * 6 -> 1,7,0
         * 7 -> 2,6
         * 8 -> 1,3
         * 9 -> 4,2
         */
        int[][] nx = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {4, 2}};
        long[][] dp = new long[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int s : nx[j]) {
                    dp[i][j] += dp[i - 1][s];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return (int) (Arrays.stream(dp[n - 1]).sum() % 1000000007);
    }

    public static void main(String[] args) {
        Solution935 solution935 = new Solution935();
        System.out.println(solution935.knightDialer(3131));
    }
}
