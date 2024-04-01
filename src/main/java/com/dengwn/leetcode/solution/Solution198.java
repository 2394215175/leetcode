package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2023-01-01
 */
public class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob(nums));
    }
}
