package com.dengwn.code.leetcode.solution.t2.h4.d1;

/**
 *
 * @author dengwenning
 * @since 2025/1/17
 **/
public class Solution2412 {
    public long minimumMoney(int[][] transactions) {
        long lost = 0;
        long mx = 0;
        for (int[] t : transactions) {
            lost += Math.max(t[0] - t[1], 0);
            mx = Math.max(mx, Math.min(t[0], t[1]));
        }
        return lost + mx;
    }
}
