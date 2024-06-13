package com.dengwn.leetcode.solution.t1.h6;

/**
 * @author: dengwn
 * @date: 2023-03-02
 **/
public class Solution1664 {
    public int waysToMakeFair(int[] nums) {
        /**
         *  dp[0][0] 前面的偶数位和
         *  dp[0][1] 前面的奇数位和
         *  dp[1][0] 后面的偶数位和
         *  dp[1][1] 后面的奇数位和
         */
        int n = nums.length;
        int[][] dp = new int[2][2];
        for (int i = 1; i < n; i++) {
            dp[1][i % 2] += nums[i];
        }
        int ans = dp[1][0] == dp[1][1] ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                dp[0][1] += nums[i - 1];
                dp[1][0] -= nums[i];
            } else {
                dp[0][0] += nums[i - 1];
                dp[1][1] -= nums[i];
            }
            if (dp[0][1] + dp[1][0] == dp[0][0] + dp[1][1]) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1664 solution1664 = new Solution1664();
        int[] nums = {2, 1, 6, 4};
        System.out.println(solution1664.waysToMakeFair(nums));
    }
}
