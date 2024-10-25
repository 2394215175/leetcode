package com.dengwn.code.leetcode.solution.t1.h1.d3;

/**
 * @author: dengwn
 * @date: 2022-12-28
 **/
public class Solution1137 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        if(n <= 2){
            return 1;
        }
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
