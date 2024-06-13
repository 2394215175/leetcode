package com.dengwn.leetcode.solution.t0.h5;

/**
 * @author: dengwn
 * @date: 2024-03-26
 **/
public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Solution518 solution518 = new Solution518();
        solution518.change(5, new int[]{1, 2, 5});
    }
}
