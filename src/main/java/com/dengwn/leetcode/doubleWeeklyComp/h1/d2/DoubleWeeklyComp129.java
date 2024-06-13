package com.dengwn.leetcode.doubleWeeklyComp.h1.d2;

/**
 * @author dengwenning
 * @since 2024/4/29
 **/
public class DoubleWeeklyComp129 {

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int bSize = 0;
                int wSize = 0;
                for (int k = i; k < i + 2; k++) {
                    for (int l = j; l < j + 2; l++) {
                        if (grid[k][l] == 'B') {
                            bSize++;
                        } else {
                            wSize++;
                        }
                    }
                }
                if (bSize <= 1 || wSize <= 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans += (row[i] - 1) * (col[j] - 1);
                }
            }
        }
        return ans;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        int n = zero + one;
        int[][] dp = new int[n][6];
        // 前面的元素
        // {当前位置为0的方案数，当前位置为1的方案数，前面0的个数，前面1的个数,前面连续0的个数，前面连续1的个数}
        // 当前位置为0 或 1
        for (int i = 0; i < 3; i++) {
            dp[0][0] = 1;
            dp[0][1] = 1;
        }


        for (int i = 1; i < n; i++) {
            // 当前位置为0
            dp[i][0] += dp[i-1][1];
            dp[i][1] += dp[i-1][0];

        }
        return 0;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp129 doubleWeeklyComp129 = new DoubleWeeklyComp129();

        doubleWeeklyComp129.numberOfStableArrays(1,1,2);
    }
}
