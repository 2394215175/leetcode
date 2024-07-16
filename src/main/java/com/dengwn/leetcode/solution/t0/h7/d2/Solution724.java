package com.dengwn.leetcode.solution.t0.h7.d2;

/**
 * @author dengwenning
 * @since 2024/7/8
 **/
public class Solution724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum == (sum - leftSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
