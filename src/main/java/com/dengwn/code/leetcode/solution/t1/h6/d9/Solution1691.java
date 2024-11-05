package com.dengwn.code.leetcode.solution.t1.h6.d9;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dengwn
 * @date: 2022-12-10
 */
public class Solution1691 {
    public int maxHeight(int[][] cuboids) {
        int length = cuboids.length;
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        int[] dp = new int[length];
        int ans = 0;
        Arrays.sort(cuboids, Comparator.comparingInt(o -> (o[0] * o[1] * o[2])));

        for (int i = 0; i < length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], cuboids[i][2] + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1691 solution1691 = new Solution1691();
        int[][] cuboids = {{36, 46, 41}, {15, 100, 100}, {75, 91, 59}, {13, 82, 64}};
        System.out.println(solution1691.maxHeight(cuboids));
    }
}
