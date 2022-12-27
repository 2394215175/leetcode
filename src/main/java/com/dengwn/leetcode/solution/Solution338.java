package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-12-23
 **/
public class Solution338 {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        Solution338 solution338 = new Solution338();
        System.out.println(solution338.countBits(5));
        System.out.println(4 & (4 - 1));
    }
}
