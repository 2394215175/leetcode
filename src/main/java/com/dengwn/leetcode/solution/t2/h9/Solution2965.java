package com.dengwn.leetcode.solution.t2.h9;

/**
 * @author dengwenning
 * @since 2024/5/31
 **/
public class Solution2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt[grid[i][j]]++;
            }
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 2) {
                a = i;
            }
            if (cnt[i] == 0) {
                b = i;
            }
        }
        return new int[]{a, b};
    }
}
