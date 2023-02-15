package com.dengwn.leetcode.solution;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: dengwn
 * @date: 2023-02-13
 **/
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (cur > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution300.lengthOfLIS(nums));


    }
}
