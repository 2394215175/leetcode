package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2022-11-28
 */
public class Solution813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] sums = new double[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        double[][] dp = new double[n][k];
        for (int i = 0; i < n; i++) {
            dp[i][0] = sums[i + 1] / (i + 1);
        }

        for (int j = 1; j < k; j++) {
            for (int i = j; i < n; i++) {
                for (int l = j - 1; l < i; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[l][j - 1] + (sums[i + 1] - sums[l + 1]) / (i - l));
                }
            }
        }

        return dp[n - 1][k - 1];
    }


    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 3, 9};
        Solution813 solution813 = new Solution813();
        System.out.println(solution813.largestSumOfAverages(nums, 3));
    }
}
