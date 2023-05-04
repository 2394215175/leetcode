package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-04-26
 **/
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int[][] row = new int[n + 1][m + 1];
        int[][] col = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    row[i][j] = row[i][j - 1] + 1;
                    col[i][j] = col[i - 1][j] + 1;
                }

                int minCol = col[i][j];
                for (int r = 0; r < row[i][j]; r++) {
                    if (col[i][j - r] < minCol) {
                        minCol = col[i][j - r];
                    }
                    if (ans > minCol * (r + 1)){
                        ans = minCol * (r + 1);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution85 solution85 = new Solution85();
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(solution85.maximalRectangle(matrix));
    }
}
