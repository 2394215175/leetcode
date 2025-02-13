package com.dengwn.code.leetcode.solution.t1.h5.d6;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/1/22
 **/
public class Solution1561 {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int ans = 0;
        for (int i = 0; i < n / 3; i++) {
            ans += piles[n - 2 * i - 2];
        }
        return ans;
    }
}
