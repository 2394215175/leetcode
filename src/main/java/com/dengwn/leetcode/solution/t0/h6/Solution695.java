package com.dengwn.leetcode.solution.t0.h6;

/**
 * @author: dengwn
 * @date: 2022-12-29
 **/
public class Solution695 {
    int[] f;

    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, 1, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        int ans = 1;
        for (int k = 0; k < 4; k++) {
            ans += dfs(grid, i + x[k], j + y[k]);
        }
        return ans;
    }

    //查询根结点
    int find(int x) {
        return f[x] == x ? x : find(f[x]);
    }

    void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        f[y] = x;
    }


}
