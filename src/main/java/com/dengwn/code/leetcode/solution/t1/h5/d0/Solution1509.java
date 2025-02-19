package com.dengwn.code.leetcode.solution.t1.h5.d0;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/1/17
 **/
public class Solution1509 {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        return Math.min(
                Math.min(nums[n - 1] - nums[3], nums[n - 2] - nums[2]),
                Math.min(nums[n - 3] - nums[1], nums[n - 4] - nums[0]));
    }
}
