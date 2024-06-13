package com.dengwn.leetcode.solution.t0.h2;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2023-04-27
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
