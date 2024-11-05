package com.dengwn.code.leetcode.weeklyComp.h4.d2;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/11/5
 **/
public class WeeklyComp422 {

    public boolean isBalanced(String num) {
        char[] array = num.toCharArray();
        int[] a = new int[2];
        for (int i = 0; i < num.length(); i++) {
            a[i % 2] += array[i] - '0';
        }
        return a[0] == a[1];
    }

    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[3]));
        dis[0][0] = 0;
        queue.add(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int step = cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nd = Math.max(dis[x][y], moveTime[nx][ny]) + step % 2 + 1;
                    if (nd < dis[nx][ny]) {
                        dis[nx][ny] = nd;
                        queue.add(new int[]{nx, ny, step + 1, nd});
                    }
                }
            }
        }
        return dis[n - 1][m - 1];
    }

    public static void main(String[] args) {
        WeeklyComp422 weeklyComp422 = new WeeklyComp422();


        int[][] moveTime = {
                {0,58},
                {27,69}};
        System.out.println(weeklyComp422.minTimeToReach(moveTime));

    }
}
