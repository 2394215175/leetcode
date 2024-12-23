package com.dengwn.code.leetcode.solution.t0.h1.d6;

/**
 * @author: dengwn
 * @date: 2023-01-30
 **/
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
