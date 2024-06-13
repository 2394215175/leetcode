package com.dengwn.leetcode.solution.t0.h3;

/**
 * @author: dengwn
 * @date: 2022-12-09
 **/
public class Solution303 {
}

class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        int length = nums.length;
        sums = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
