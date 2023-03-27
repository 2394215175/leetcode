package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: dengwn
 * @date: 2023-03-22
 **/
public class Solution1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] params = new int[n][2];
        for (int i = 0; i < n; i++) {
            params[i][0] = ages[i];
            params[i][1] = scores[i];
        }

        Arrays.sort(params, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (!(params[i][0] > params[j][0] && params[i][1] <= params[j][1])) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += params[i][1];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int bestTeamScore1(int[] scores, int[] ages) {
        int n = scores.length, ans = 0;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; ++i) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> scores[i] != scores[j] ? scores[i] - scores[j] : ages[i] - ages[j]);

        int[] f = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (ages[ids[j]] <= ages[ids[i]]) {
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            f[i] += scores[ids[i]];
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution1626 solution1626 = new Solution1626();
        int[] scores = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] ages = {811, 364, 124, 873, 790, 656, 581, 446, 885, 134};
        System.out.println(solution1626.bestTeamScore1(scores, ages));
    }
}
