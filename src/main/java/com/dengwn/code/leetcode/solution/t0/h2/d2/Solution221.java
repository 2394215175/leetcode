package com.dengwn.code.leetcode.solution.t0.h2.d2;

/**
 *
 * @author dengwenning
 * @since 2025/2/13
 **/
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] cnt = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                cnt[i + 1][j + 1] = Math.max(cnt[i][j], Math.max(cnt[i][j + 1], cnt[i + 1][j]));
                ans = Math.max(ans, cnt[i + 1][j + 1]);
            }
        }
        return ans * ans;
    }

}
