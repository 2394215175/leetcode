package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/4/29
 **/
public class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // 枚举每条对角线
        // n - 1只有一个元素，不用管
        for (int i = 0; i < n - 1; i++) {
            // 初始坐标 {x,y} = {i, 0}
            for (int x = i, y = 0; x < n && y < m; x++, y++) {
                for (int a = x + 1, b = y + 1; a < n && b < m; a++, b++) {
                    if (mat[x][y] > mat[a][b]) {
                        swap(mat, x, y, a, b);
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            // 初始坐标 {x,y} = {0, i}
            for (int x = 0, y = i; x < n && y < m; x++, y++) {
                for (int a = x + 1, b = y + 1; a < n && b < m; a++, b++) {
                    if (mat[x][y] > mat[a][b]) {
                        swap(mat, x, y, a, b);
                    }
                }
            }
        }

        return mat;
    }

    private void swap(int[][] mat, int x, int y, int a, int b) {
        int temp = mat[x][y];
        mat[x][y] = mat[a][b];
        mat[a][b] = temp;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {11, 25, 66, 1, 69, 7},
                {23, 55, 17, 45, 15, 52},
                {75, 31, 36, 44, 58, 8},
                {22, 27, 33, 25, 68, 4},
                {84, 28, 14, 11, 5, 50}
        };
        Solution1329 solution1329 = new Solution1329();
        int[][] ans = solution1329.diagonalSort(mat);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
