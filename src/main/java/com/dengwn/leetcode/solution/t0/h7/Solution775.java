package com.dengwn.leetcode.solution.t0.h7;

/**
 * @author: dengwn
 * @date: 2022-11-16
 **/
public class Solution775 {
    public boolean isIdealPermutation(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(max, nums[i - 2]);

            if (max > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
