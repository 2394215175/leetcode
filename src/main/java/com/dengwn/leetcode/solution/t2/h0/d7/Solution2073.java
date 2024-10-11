package com.dengwn.leetcode.solution.t2.h0.d7;

/**
 *
 * @author dengwenning
 * @since 2024/9/29
 **/
public class Solution2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(tickets[i], tickets[k] - (i > k ? 1 : 0));
        }
        return ans;
    }
}
