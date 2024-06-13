package com.dengwn.leetcode.solution.t0.h6;

/**
 * @author: dengwn
 * @date: 2023-02-17
 **/
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < cnt.length; i++) {
            ans += dp[i] == maxLen ? cnt[i] : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution673 solution673 = new Solution673();
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(solution673.findNumberOfLIS(nums));
    }
}
