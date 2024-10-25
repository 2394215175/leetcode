package com.dengwn.code.leetcode.solution.t0.h0.d4;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-01-12
 **/
public class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int j = 1;
            while (j <= num && i + j < n) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                j++;
            }
        }
        return dp[n - 1];
    }

    public int jump1(int[] nums) {
        int n = nums.length;
        int max = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i] + i, max);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution45.jump(nums));
    }
}
