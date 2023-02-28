package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-02-22
 **/
public class Solution1140 {
    public int stoneGameII(int[] piles) {
        int s = 0, n = piles.length;
        int[][] f = new int[n][n + 1];
        for (int i = n - 1; i >= 0; --i) {
            s += piles[i];
            for (int m = 1; m <= i / 2 + 1; ++m) {
                if (i + m * 2 >= n) {
                    f[i][m] = s;
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        f[i][m] = Math.max(f[i][m], s - f[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        return f[0][1];
    }

    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        Solution1140 solution1140 = new Solution1140();
        System.out.println(solution1140.stoneGameII(piles));
    }
}
