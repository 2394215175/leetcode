package com.dengwn.leetcode.solution.t1.h0;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-02-06
 **/
public class Solution1091 {
    int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int step = 1;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (x == n - 1 && y == n - 1) {
                    return step;
                }
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
