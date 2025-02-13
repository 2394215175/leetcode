package com.dengwn.code.leetcode.solution.t3.h4.d2;

/**
 *
 * @author dengwenning
 * @since 2025/1/22
 **/
public class Solution3423 {
    public int maxAdjacentDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.abs(nums[i] - nums[(i + 1) % n]));
        }
        return ans;
    }
}
