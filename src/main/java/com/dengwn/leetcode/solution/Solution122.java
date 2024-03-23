package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2024-03-23
 **/
public class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            if (dp0 < dp1 + prices[i]) {
                dp0 = dp1 + prices[i];
            }
            if (dp1 < dp0 - prices[i]) {
                dp1 = dp0 - prices[i];
            }
        }
        return dp0;
    }
}
