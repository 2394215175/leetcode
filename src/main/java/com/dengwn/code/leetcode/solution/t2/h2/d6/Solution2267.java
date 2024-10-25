package com.dengwn.code.leetcode.solution.t2.h2.d6;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/10/23
 **/
public class Solution2267 {

    boolean[][][] vis;

    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m][(n + m + 1) / 2];
        if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[n - 1][m - 1] == '(') {
            return false;
        }

        return dfs(0, 0, 0, grid);
    }

    public boolean dfs(int x, int y, int c, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (x >= n || y >= m) {
            return false;
        }
        if (c < 0 || c > n - x + m - y - 1) {
            return false;
        }
        if (vis[x][y][c]) {
            return false;
        }

        if (x == n - 1 && y == m - 1) {
            return c == 1;
        }
        vis[x][y][c] = true;
        c += grid[x][y] == '(' ? 1 : -1;
        return dfs(x + 1, y, c, grid) || dfs(x, y + 1, c, grid);
    }

}

