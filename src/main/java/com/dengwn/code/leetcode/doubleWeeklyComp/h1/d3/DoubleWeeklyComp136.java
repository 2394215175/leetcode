package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/8/3
 **/
public class DoubleWeeklyComp136 {

    public int winningPlayerCount(int n, int[][] pick) {
        int[][] cnt = new int[n][11];
        for (int[] p : pick) {
            int x = p[0];
            int y = p[1];
            cnt[x][y]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                if (cnt[i][j] > i) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // 判断行回文
        int ans1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                if (grid[i][j] != grid[i][m - 1 - j]) {
                    ans1++;
                }
            }
        }
        // 判断列回文
        int ans2 = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != grid[n - 1 - i][j]) {
                    ans2++;
                }
            }
        }
        return Math.min(ans1, ans2);
    }

    public int minFlips1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                int a = grid[i][j];
                int b = grid[i][m - 1 - j];
                int c = grid[n - 1 - i][j];
                int d = grid[n - 1 - i][m - j - 1];
                int sum = a + b + c + d;
                ans += Math.min(sum, 4 - sum);
            }
        }
        int cnt1 = 0;
        int cnt = 0;
        if (n % 2 == 1) {
            for (int i = 0; i < m / 2; i++) {
                if (grid[n / 2][i] + grid[n / 2][m - i - 1] == 1) {
                    cnt1++;
                }
            }
            for (int i = 0; i < m; i++) {
                cnt += grid[n / 2][i];
            }
        }
        if (m % 2 == 1) {
            for (int i = 0; i < n / 2; i++) {
                if (grid[i][m / 2] + grid[n - 1 - i][m / 2] == 1) {
                    cnt1++;
                }
            }
            for (int i = 0; i < n; i++) {
                cnt += grid[i][m / 2];
            }
        }

        if (n % 2 == 1 && m % 2 == 1 && grid[n / 2][m / 2] == 1) {
            cnt--;
        }

        cnt += cnt1;
        if (cnt >= 4) {
            ans += Math.min(cnt1, 4 - cnt1);
        } else {
            ans += cnt1;
        }
        return ans;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp136 doubleWeeklyComp = new DoubleWeeklyComp136();

//        int[][] pick = {{0, 8}, {0, 3}};
//        System.out.println(doubleWeeklyComp.minFlips(pick));

        int[][] grid = {{0}, {1}, {1}, {1}, {1}};
        System.out.println(doubleWeeklyComp.minFlips1(grid));


    }
}
