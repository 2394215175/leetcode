package com.dengwn.code.leetcode.solution.t1.h3.d3;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-05-16
 **/
public class Solution1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] dp = new int[d][n];
        for (int i = 0; i < d; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);
        }
        for (int i = 1; i < d; i++) {
            for (int j = i; j < n; j++) {
                int max = 0;
                // 这里反向操作是减少反复比较
                for (int k = j; k >= i; --k) {
                    max = Math.max(max, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], max + dp[i - 1][k - 1]);
                }

            }
        }
        return dp[d - 1][n - 1];
    }

    public int max(int[] jobDifficulty, int start, int end) {
        int ans = 0;
        for (int i = start; i <= end; i++) {
            ans = Math.max(jobDifficulty[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] jobDifficulty = {11, 111, 22, 222, 33, 333, 44, 444};
        int d = 6;
        Solution1335 solution1335 = new Solution1335();
        System.out.println(solution1335.minDifficulty(jobDifficulty, d));
    }
}
