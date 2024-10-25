package com.dengwn.code.leetcode.solution.t0.h0.d5;

/**
 * @author: dengwn
 * @date: 2023-01-03
 **/
public class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxTo = nums[0];
        for (int i = 0; i < n; i++) {
            int next = i + nums[i];
            if (i <= maxTo && next > maxTo) {
                maxTo = next;
            }
        }
        return maxTo >= n - 1;
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] nums = {2, 0, 0};
        System.out.println(solution55.canJump(nums));
    }
}
