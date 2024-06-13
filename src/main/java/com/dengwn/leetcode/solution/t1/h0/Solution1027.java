package com.dengwn.leetcode.solution.t1.h0;

/**
 * @author dengwn
 * @date: 2023-04-22
 */
public class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = dp[j][d] + 1;
                maxLen = Math.max(maxLen, dp[i][d]);
            }
        }
        return maxLen + 1;
    }

    public static void main(String[] args) {
        Solution1027 solution1027 = new Solution1027();
        int[] nums = {24, 13, 1, 100, 0, 94, 3, 0, 3};
        System.out.println(solution1027.longestArithSeqLength(nums));
    }
}
