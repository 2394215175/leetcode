package com.dengwn.leetcode.solution.t0.h1;

import java.util.Arrays;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-01-17
 **/
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[n - 1][i]);
        }
        return ans;
    }
}
