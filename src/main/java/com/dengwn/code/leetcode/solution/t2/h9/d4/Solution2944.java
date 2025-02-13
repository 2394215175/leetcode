package com.dengwn.code.leetcode.solution.t2.h9.d4;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/1/24
 **/
public class Solution2944 {
    public int minimumCoins(int[] f) {
        int n = f.length;
        for (int i = (n + 1) / 2 - 1; i > 0; i--) {
            int mn = Integer.MAX_VALUE;
            for (int j = i; j <= i * 2; j++) {
                mn = Math.min(mn, f[j]);
            }
            f[i - 1] += mn;
        }
        return f[0];
    }

    public static void main(String[] args) {
        Solution2944 solution = new Solution2944();
        System.out.println(solution.minimumCoins(new int[]{26, 18, 6, 12, 49, 47, 45, 2}));
    }
}
