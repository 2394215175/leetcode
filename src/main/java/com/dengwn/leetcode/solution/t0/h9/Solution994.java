package com.dengwn.leetcode.solution.t0.h9;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2023-01-16
 **/
public class Solution994 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Set<int[]>> queue = new LinkedList<>();
        Set<int[]> start = new HashSet<>();
        int size = 0;
        int ans = 0;
        int round = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    size++;
                    ans++;
                    start.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    size++;
                }
            }
        }
        queue.add(start);

        while (ans < size && !queue.isEmpty()) {
            Set<int[]> cur = queue.poll();
            Set<int[]> next = new HashSet<>();
            for (int[] ints : cur) {
                for (int i = 0; i < 4; i++) {
                    int x = ints[0] + dirs[i][0];
                    int y = ints[1] + dirs[i][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        ans++;
                        next.add(new int[]{x, y});
                    }
                }
            }
            if (!next.isEmpty()) {
                round++;
                queue.add(next);
            }
        }
        return size == ans ? round : -1;
    }
}
