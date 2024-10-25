package com.dengwn.code.leetcode.solution.t0.h4;

/**
 * @author dengwn
 * @date: 2022-12-15
 */
public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
            } else {
                ans = Math.max(ans, temp);
                temp = 0;
            }
        }

        ans = Math.max(ans, temp);
        return ans;
    }
}
