package com.dengwn.code.leetcode.solution.t0.h0.d3;

/**
 * @author: dengwn
 * @date: 2023-02-28
 **/
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subBoxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.' && (++rows[i][c - '1'] > 1 || ++columns[j][c - '1'] > 1 || ++subBoxes[i / 3][j / 3][c - '1'] > 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
