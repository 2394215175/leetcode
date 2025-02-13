package com.dengwn.code.leetcode.solution.t0.h0.d5;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/2/7
 **/
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int l = 0, r = n - 1;
        int t = 0, d = n - 1;
        int i = 1;
        while (i <= n * n) {
            for (int j = l; j <= r; j++) ans[t][j] = i++;
            t++;
            for (int j = t; j <= d; j++) ans[j][r] = i++;
            r--;
            for (int j = r; j >= l; j--) ans[d][j] = i++;
            d--;
            for (int j = d; j >= t; j--) ans[j][l] = i++;
            l++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        System.out.println(Arrays.deepToString(solution59.generateMatrix(3)));
    }
}
