package com.dengwn.code.leetcode.solution.t0.h4;

/**
 * @author dengwenning
 * @since 2024/6/11
 **/
public class Solution416 {

    public int countBattleships(char[][] board) {
        int count = 0;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                count++;
                // 向下
                int down = i;
                while (down < n && board[down][j] == 'X') {
                    board[down][j] = '.';
                    down++;
                }
                int right = j + 1;
                while (right < m && board[i][right] == 'X') {
                    board[i][right] = '.';
                    right++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        Solution416 solution416 = new Solution416();
        System.out.println(solution416.countBattleships(board));

    }
}
