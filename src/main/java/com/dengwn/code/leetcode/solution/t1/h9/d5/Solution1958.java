package com.dengwn.code.leetcode.solution.t1.h9.d5;

/**
 * @author dengwenning
 * @since 2024/7/12
 **/
public class Solution1958 {
    int[][] xy = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        int m = board[0].length;
        for (int[] dis : xy) {
            int nr = rMove + dis[0];
            int nc = cMove + dis[1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] == color || board[nr][nc] == '.') {
                continue;
            }
            while (true) {
                nr += dis[0];
                nc += dis[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] == '.') {
                    break;
                }
                if (board[nr][nc] == color) {
                    return true;
                }
            }
        }
        return false;
    }
}
