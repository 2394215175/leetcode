package com.dengwn.code.leetcode.solution.t0.h6.d6;

/**
 *
 * @author dengwenning
 * @since 2024/11/18
 **/
public class Solution661 {

    int[][] d = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = img[i][j];
                int count = 1;
                for (int[] di : d) {
                    int x = i + di[0];
                    int y = j + di[1];
                    if (0 <= x && x < n && 0 <= y && y < m){
                        sum += img[x][y];
                        count++;
                    }
                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }
}
