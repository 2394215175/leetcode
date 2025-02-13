package com.dengwn.code.leetcode.solution.t3.h2.d4;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/1/20
 **/
public class Solution3249 {
    public long minCost(int n, int[][] cost) {
        long[][][] dp = new long[n / 2 + 1][3][3];
        for (int i = 0; i < n / 2; i++) {
            int[] row1 = cost[i];
            int[] row2 = cost[n - 1 - i];
            for (int preJ = 0; preJ < 3; preJ++) {
                for (int preK = 0; preK < 3; preK++) {
                    long res = Long.MAX_VALUE;
                    for (int j = 0; j < 3; j++) {
                        if (j == preJ) {
                            continue;
                        }
                        for (int k = 0; k < 3; k++) {
                            if (k == j || k == preK) {
                                continue;
                            }
                            res = Math.min(res, dp[i][j][k] + row1[j] + row2[k]);
                        }
                    }
                    dp[i + 1][preJ][preK] = res;
                }
            }
        }
        return Arrays.stream(dp[n / 2]).flatMapToLong(Arrays::stream).min().getAsLong();
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] cost = {
                {3, 5, 7},
                {6, 2, 9},
                {4, 8, 1},
                {7, 3, 5}
        };
        Solution3249 solution3249 = new Solution3249();
        System.out.println(solution3249.minCost(n, cost));


    }
}
