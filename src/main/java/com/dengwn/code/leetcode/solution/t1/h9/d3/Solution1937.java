package com.dengwn.code.leetcode.solution.t1.h9.d3;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author dengwenning
 * @since 2024/6/29
 **/
public class Solution1937 {
    public long maxPoints(int[][] points) {
        int m = points[0].length;
        long[] dp = new long[m];
        long[][] max = new long[m + 1][2];
        for (long[] longs : max) {
            Arrays.fill(longs, Integer.MIN_VALUE);
        }
        for (int[] point : points) {
            for (int j = 0; j < m; j++) {
                max[j + 1][0] = Math.max(max[j][0], dp[j] + j);
            }
            for (int j = m - 1; j >= 0; j--) {
                max[j][1] = Math.max(max[j + 1][1], dp[j] - j);
            }

            long[] tmep = new long[m];
            for (int j = 0; j < m; j++) {
                tmep[j] = Math.max(point[j] - j + max[j + 1][0], tmep[j]);
                tmep[j] = Math.max(point[j] + j + max[j][1], tmep[j]);
            }
            dp = tmep;
        }

        return Arrays.stream(dp).max().getAsLong();
    }

    public static void main(String[] args) {
        Solution1937 solution1937 = new Solution1937();

        int[][] points = {
                {0, 3, 0, 4, 2},
                {5, 4, 2, 4, 1},
                {5, 0, 0, 5, 1},
                {2, 0, 1, 0, 3}};
        System.out.println(solution1937.maxPoints(points));

    }
}
