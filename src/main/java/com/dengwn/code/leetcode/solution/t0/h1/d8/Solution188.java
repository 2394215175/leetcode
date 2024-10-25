package com.dengwn.code.leetcode.solution.t0.h1.d8;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/9/25
 **/
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE / 2);
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            int price = prices[i];
            buy[0] = Math.max(buy[0], sell[0] - price);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - price);
                sell[j] = Math.max(sell[j], buy[j - 1] + price);
            }
        }
        return sell[k];
    }

    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        System.out.println(solution188.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
