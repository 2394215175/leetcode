package com.dengwn.code.leetcode.solution.t0.h2.d6;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-09
 **/
public class Solution268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber1(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            a += nums[i];
            b += (i + 1);
        }
        return b - a;
    }
}
