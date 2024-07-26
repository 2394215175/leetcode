package com.dengwn.leetcode.solution.t3.h0.d9;

/**
 * @author dengwenning
 * @since 2024/7/19
 **/
public class Solution3096 {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (possible[i] == 1 ? 1 : -1);
        }
        for (int i = 1; i < n; i++) {
            if (sum[i] > sum[n] - sum[i]) {
                return i;
            }
        }
        return -1;
    }
}
