package com.dengwn.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-05-08
 **/
public class Solution1263 {
    int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minPushBox(char[][] grid) {
        int x1 = -1;
        int y1 = -1;
        int endX = -1;
        int endY = -1;
        int x2 = -1;
        int y2 = -1;

        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'B') {
                    x1 = i;
                    y1 = j;
                } else if (grid[i][j] == 'T') {
                    endX = i;
                    endY = j;
                } else if (grid[i][j] == 'S') {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1, x2, y2, 0});
        boolean[][][][] vis = new boolean[n][m][n][m];
        vis[x1][y1][x2][y2] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int xb = cur[0];
            int yb = cur[1];
            int xp = cur[2];
            int yp = cur[3];
            int step = cur[4];
            if (xb == endX && yb == endY) {
                return step;
            }
            // 移动都是人移动
            for (int i = 0; i < 4; i++) {
                int nxp = xp + d[i][0];
                int nyp = yp + d[i][1];
                // 如果移动合法
                if (nxp >= 0 && nxp < n && nyp >= 0 && nyp < m && grid[nxp][nyp] != '#') {
                    // 判断下一个位置是不是箱子，如果是，箱子也要移动相应的范围，且步数+1
                    if (nxp == xb && nyp == yb) {
                        // 箱子移动的范围也要合法
                        int nxb = xb + d[i][0];
                        int nyb = yb + d[i][1];
                        if (nxb >= 0 && nxb < n && nyb >= 0 && nyb < m && grid[nxb][nyb] != '#' && !vis[nxb][nyb][nxp][nyp]) {
                            queue.offerLast(new int[]{nxb, nyb, nxp, nyp, step + 1});
                            vis[nxb][nyb][nxp][nyp] = true;
                        }
                    } else {
                        // 如果不是箱子，箱子不动，判断之前是否来过
                        if (!vis[xb][yb][nxp][nyp]) {
                            queue.offerFirst(new int[]{xb, yb, nxp, nyp, step});
                            vis[xb][yb][nxp][nyp] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'#', '#', '#', '#', '#', '#'},
                {'#', 'T', '.', '.', '#', '#'},
                {'#', '.', '#', 'B', '.', '#'},
                {'#', '.', '.', '.', '.', '#'},
                {'#', '.', '.', '.', 'S', '#'},
                {'#', '#', '#', '#', '#', '#'}
        };

        Solution1263 solution1263 = new Solution1263();
        System.out.println(solution1263.minPushBox(grid));

    }
}
