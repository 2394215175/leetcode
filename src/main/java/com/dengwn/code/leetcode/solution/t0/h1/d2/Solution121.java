package com.dengwn.code.leetcode.solution.t0.h1.d2;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            ans = Math.max(ans, prices[i] - min);
        }

        return ans;
    }
}
