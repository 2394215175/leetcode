package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-02-06
 **/
public class Solution1210 {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        boolean[][][] visited = new boolean[n][n][2];
        visited[0][0][0] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int s = cur[2];
                if (x == n - 1 && y == n - 2) {
                    return step;
                }
                if (s == 0) {
                    // 水平状态
                    // 右移
                    if (y + 2 < n && grid[x][y + 2] == 0 && !visited[x][y + 1][0]) {
                        visited[x][y + 1][0] = true;
                        queue.offer(new int[]{x, y + 1, 0});
                    }
                    if (x + 1 < n && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                        if (!visited[x + 1][y][0]) {
                            // 下移
                            visited[x + 1][y][0] = true;
                            queue.offer(new int[]{x + 1, y, 0});
                        }
                        if (!visited[x][y][1]) {
                            // 向下旋转
                            visited[x][y][1] = true;
                            queue.offer(new int[]{x, y, 1});
                        }
                    }
                } else {
                    // 竖直方向
                    if (y + 1 < n && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                        if (!visited[x][y + 1][1]) {
                            // 右移
                            visited[x][y + 1][1] = true;
                            queue.offer(new int[]{x, y + 1, 1});
                        }
                        if (!visited[x][y][0]) {
                            // 向上旋转
                            visited[x][y][0] = true;
                            queue.offer(new int[]{x, y, 0});
                        }
                    }
                    // 下移
                    if (x + 2 < n && grid[x + 2][y] == 0 && !visited[x + 1][y][1]) {
                        visited[x + 1][y][1] = true;
                        queue.offer(new int[]{x + 1, y, 1});
                    }
                }
            }
            step++;
        }

        return -1;
    }


    public static void main(String[] args) {
        Solution1210 solution1210 = new Solution1210();
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution1210.minimumMoves(grid));
    }
}
