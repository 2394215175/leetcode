package com.dengwn.leetcode.solution.t0.h3;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-02-14
 **/
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 1; i < max; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.println(solution322.coinChange(coins, amount));
    }
}
