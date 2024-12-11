package com.dengwn.code.leetcode.solution.t0.h9.d9;

/**
 *
 * @author dengwenning
 * @since 2024/12/6
 **/
public class Solution999 {
    public int numRookCaptures(char[][] board) {
        int n = 8;
        int x = -1, y = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R'){
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x != -1) break;
        }
        int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;
        for (int[] d : dis) {
            int nx = x + d[0];
            int ny = y + d[1];
            while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[nx][ny] == 'B') {
                    break;
                }
                if (board[nx][ny] == 'p') {
                    ans++;
                    break;
                }
                nx += d[0];
                ny += d[1];
            }
        }
        return ans;
    }
}
