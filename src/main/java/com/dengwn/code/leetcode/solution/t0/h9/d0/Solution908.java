package com.dengwn.code.leetcode.solution.t0.h9.d0;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/10/21
 **/
public class Solution908 {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] - k - nums[0] - k, 0);
    }
}
