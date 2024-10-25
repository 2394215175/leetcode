package com.dengwn.code.leetcode.solution.t1.h3.d0;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/10/23
 **/
public class Solution1301 {
    public int[] pathsWithMaxScore(List<String> board) {
        int MOD = (int) (1e9 + 7);
        int n = board.size();
        int m = board.get(0).length();
        char[][] b = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = board.get(i).charAt(j);
            }
        }

        long[][][] dp = new long[n][m][2];
        dp[0][0] = new long[]{0, 1};
        for (int i = 1; i < n; i++) {
            if (b[i][0] == 'X' || dp[i - 1][0][0] == -1) {
                dp[i][0][0] = -1;
                dp[i][0][1] = 0;
            } else {
                dp[i][0][0] = dp[i - 1][0][0] + b[i][0] - '0';
                dp[i][0][1] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            if (b[0][i] == 'X' || dp[0][i - 1][0] == -1) {
                dp[0][i][0] = -1;
                dp[0][i][1] = 0;
            } else {
                dp[0][i][0] = dp[0][i - 1][0] + b[0][i] - '0';
                dp[0][i][1] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (b[i][j] == 'X') {
                    dp[i][j][0] = -1;
                    dp[i][j][1] = 0;
                    continue;
                }
                long left = dp[i - 1][j][0];
                long top = dp[i][j - 1][0];
                long leftTop = dp[i - 1][j - 1][0];
                long max = Math.max(left, Math.max(top, leftTop));
                long score = b[i][j] == 'S' ? 0 : b[i][j] - '0';
                if (max != -1) {
                    dp[i][j][0] = max + score;
                    if (left == max) {
                        dp[i][j][1] += dp[i - 1][j][1];
                    }
                    if (top == max) {
                        dp[i][j][1] += dp[i][j - 1][1];
                    }
                    if (leftTop == max) {
                        dp[i][j][1] += dp[i - 1][j - 1][1];
                    }
                }
                dp[i][j][1] %= MOD;
            }
        }

        int res1 = (int) dp[n - 1][m - 1][0];
        int res2 = (int) (dp[n - 1][m - 1][1] % MOD);
        return new int[]{res1, res2};
    }

    public static void main(String[] args) {
        Solution1301 solution1301 = new Solution1301();
        List<String> list = Arrays.asList(
                "EX", "XS"
        );
        int[] res = solution1301.pathsWithMaxScore(list);
        System.out.println(Arrays.toString(res));

        System.out.println(4631081169483718960L);

    }
}
