package com.dengwn.leetcode.solution.t0.h1.d2;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/9/25
 **/
public class Solution123 {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE / 2;
        int sell1 = Integer.MIN_VALUE / 2;
        int buy2 = Integer.MIN_VALUE / 2;
        int sell2 = Integer.MIN_VALUE / 2;
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return Math.max(0, Math.max(sell1, sell2));
    }

    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        System.out.println(solution123.maxProfit(new int[]{14, 9, 10, 12, 4, 8, 1, 16}));
    }
}
