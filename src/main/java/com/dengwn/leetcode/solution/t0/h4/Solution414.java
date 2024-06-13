package com.dengwn.leetcode.solution.t0.h4;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2022-12-14
 */
public class Solution414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int n = 2;
        int pre = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (n == 0) {
                return nums[i];
            }
            if (nums[i] < pre) {
                n--;
            }
        }
        return nums[length - 1];
    }
}
