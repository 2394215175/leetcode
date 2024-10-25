package com.dengwn.code.leetcode.solution.t1.h6;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-03-29
 **/
public class Solution1641 {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j; k < 5; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        return Arrays.stream(dp[n-1]).sum();
    }

    public int countVowelStrings1(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans+=i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1641 solution1641 = new Solution1641();
        System.out.println(solution1641.countVowelStrings1(3));
    }
}
