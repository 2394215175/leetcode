package com.dengwn.code.leetcode.solution.t0.h5.d9;

/**
 *
 * @author dengwenning
 * @since 2025/2/5
 **/
public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }
        return x * y;
    }
}
