package com.dengwn.leetcode.solution.t0.h0.d5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwn
 * @date: 2023-04-27
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int x = 0;
        int y = 0;
        boolean[][] visited = new boolean[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int dir = 0;
        while (ans.size() < m * n) {
            ans.add(matrix[y][x]);
            visited[y][x] = true;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (ny >= m || nx < 0 || nx >= n || ny < 0 || visited[ny][nx]) {
                dir = (dir + 1) % 4;
            }
            x += dx[dir];
            y += dy[dir];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Solution54 solution54 = new Solution54();
        System.out.println(solution54.spiralOrder(matrix));
    }


}
