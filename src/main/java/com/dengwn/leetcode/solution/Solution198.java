package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2023-01-01
 */
public class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int two = i - 2 >= 0 ? dp[i - 2] : 0;
            int three = i - 3 >= 0 ? dp[i - 3] : 0;
            dp[i] = Math.max(two, three) + nums[i];
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob(nums));
    }
}
