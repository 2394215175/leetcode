package com.dengwn.leetcode.solution.t1.h2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-06-19
 **/
public class Solution1254 {
    int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < m; i++) {
            dfs(grid, 0, i);
            dfs(grid, n - 1, i);
        }

        for (int i = 0; i < n; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, m - 1);
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = 1;
        while (!queue.isEmpty()) {
            for (int p = queue.size(); p > 0; p--) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int q = 0; q < 4; q++) {
                    int nx = x + d[q][0];
                    int ny = y + d[q][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                    }
                }
                grid[x][y] = 1;
            }
        }
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] != 0) {
            return;
        }
        grid[x][y] = 1;
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }


    public static void main(String[] args) {
        Solution1254 solution1254 = new Solution1254();
        int[][] grid = {
                {0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1, 1, 1}};

        System.out.println(solution1254.closedIsland(grid));
    }
}
