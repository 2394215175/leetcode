package com.dengwn.code.leetcode.solution.t0.h2.d8;

/**
 *
 * @author dengwenning
 * @since 2024/12/27
 **/
public class Solution289 {
    public void gameOfLife(int[][] board) {
        int[][] dis = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int n = board.length;
        int m = board[0].length;
        int[][][] cnt = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    int dx = dis[k][0];
                    int dy = dis[k][1];
                    int nx = dx + i;
                    int ny = dy + j;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        cnt[i][j][board[nx][ny]]++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && (cnt[i][j][1] < 2 || cnt[i][j][1] > 3)) {
                    board[i][j] = 0;
                }else if (board[i][j] == 0 && cnt[i][j][1] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution289 solution289 = new Solution289();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        solution289.gameOfLife(board);

    }
}
