package com.dengwn.leetcode.solution.t1.h7;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-22
 **/
public class Solution1799 {
    public int maxScore(int[] nums) {
        int m = nums.length;
        int[] dp = new int[1 << m];
        int[][] gcdTmp = new int[m][m];
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                gcdTmp[i][j] = gcd(nums[i], nums[j]);
            }
        }
        int all = 1 << m;
        for (int s = 1; s < all; ++s) {
            int t = Integer.bitCount(s);
            if ((t & 1) != 0) {
                continue;
            }
            for (int i = 0; i < m; ++i) {
                if (((s >> i) & 1) != 0) {
                    for (int j = i + 1; j < m; ++j) {
                        if (((s >> j) & 1) != 0) {
                            dp[s] = Math.max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + t / 2 * gcdTmp[i][j]);
                        }
                    }
                }
            }
        }
        return dp[all - 1];
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution1799 solution1799 = new Solution1799();
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(solution1799.maxScore(nums));
    }
}
