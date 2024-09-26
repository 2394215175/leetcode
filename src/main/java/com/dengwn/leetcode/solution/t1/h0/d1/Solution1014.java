package com.dengwn.leetcode.solution.t1.h0.d1;

/**
 *
 * @author dengwenning
 * @since 2024/9/23
 **/
public class Solution1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, values[i] - i + pre);
            pre = Math.max(pre, values[i] + i);
        }
        return ans;
    }
}
