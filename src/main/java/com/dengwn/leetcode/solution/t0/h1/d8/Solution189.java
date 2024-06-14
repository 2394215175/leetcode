package com.dengwn.leetcode.solution.t0.h1.d8;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            nums[i] = copy[(10000 * n - k + i) % n];
        }
    }
}
