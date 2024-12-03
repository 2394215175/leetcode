package com.dengwn.code.leetcode.solution.t0.h7.d3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2022-12-29
 **/
public class Solution733 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int currColor = image[sr][sc];
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = cur[0] + dx[i];
                int my = cur[1] + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }


    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor != color) {
            dfs(image, sr, sc, currColor, color);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int currColor, int color) {
        if (image[x][y] == currColor) {
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, currColor, color);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        Solution733 solution733 = new Solution733();
        System.out.println(solution733.floodFill1(image, sr, sc, newColor));
    }

}
