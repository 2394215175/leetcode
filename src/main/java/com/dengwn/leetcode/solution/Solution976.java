package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-28
 **/
public class Solution976 {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        return 0;
    }
}
