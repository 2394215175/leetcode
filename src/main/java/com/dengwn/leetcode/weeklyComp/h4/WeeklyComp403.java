package com.dengwn.leetcode.weeklyComp.h4;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/6/23
 **/
public class WeeklyComp403 {

    public double minimumAverage(int[] nums) {
        double ans = 200;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int sum = nums[i] + nums[n - 1 - i];
            ans = Math.min(ans, sum / 2.0);
        }
        return ans;
    }

    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int up = n - 1;
        int down = 0;
        int left = m - 1;
        int right = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        return (down - up + 1) * (right - left + 1);
    }

    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int flag = -1;
        for (int i = 1; i < n; i++) {
            // 0表示当前位置的符号是正
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1] + nums[i]);
            // 1 表示当前位置的符号是负
            dp[i][1] = dp[i - 1][0] - nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int minimumSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    if (j < m - 1) {
                        right[i][j] = right[i][j + 1] + 1;
                    } else {
                        right[i][j] = 1;
                    }
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == 1) {
                    if (i < n - 1) {
                        down[i][j] = down[i + 1][j] + 1;
                    } else {
                        down[i][j] = 1;
                    }
                }
            }
        }

        int[][][] dp = new int[4][n][m];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[0][i][j] = 0;
            }
        }

        for (int k = 1; k < 4; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        for (int x = 0; x < i + 1; x++) {
                            for (int y = 0; y < j + 1; y++) {
                                if (grid[x][y] == 1) {
                                    int min_height = Math.min(down[i][j], i - x + 1);
                                    int min_width = Math.min(right[x][j], j - y + 1);
                                    int area = min_height * min_width;
                                    if (area > 0) {
                                        dp[k][i][j] = Math.min(dp[k][i][j], dp[k - 1][x][y] + area);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return dp[3][n - 1][m - 1];
    }


    public static void main(String[] args) {
        WeeklyComp403 weeklyComp403 = new WeeklyComp403();

//        int[][] grid = {{0, 0, 0}, {1, 0, 1}};
//        System.out.println(weeklyComp403.minimumArea(grid));

//        int[] nums = {1, -2, -100, 20};
//        System.out.println(weeklyComp403.maximumTotalCost(nums));

        int[][] grid = {{1, 0, 1}, {1, 1, 1}};
        System.out.println(weeklyComp403.minimumSum(grid));


    }
}
