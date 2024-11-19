package com.dengwn.code.leetcode.solution.t3.h2.d4;

/**
 *
 * @author dengwenning
 * @since 2024/11/18
 **/
public class Solution3240 {
    public int minFlips(int[][] grid) {
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
        if (n % 2 == 1 && m % 2 == 1) {
            ans += grid[n / 2][m / 2];
        }
        int diff = 0;
        int cnt1 = 0;
        if (n % 2 > 0) {
            // 统计正中间这一排
            for (int j = 0; j < m / 2; j++) {
                if (grid[n / 2][j] != grid[n / 2][m - 1 - j]) {
                    diff++;
                } else {
                    cnt1 += grid[n / 2][j] * 2;
                }
            }
        }
        if (m % 2 > 0) {
            // 统计正中间这一列
            for (int i = 0; i < n / 2; i++) {
                if (grid[i][m / 2] != grid[n - 1 - i][m / 2]) {
                    diff++;
                } else {
                    cnt1 += grid[i][m / 2] * 2;
                }
            }
        }

        return ans + (diff > 0 ? diff : cnt1 % 4);
    }

    public static void main(String[] args) {

        int[][] grid = {{0, 1, 1, 0, 0, 1}};
        Solution3240 solution3240 = new Solution3240();
        System.out.println(solution3240.minFlips(grid));
    }
}
