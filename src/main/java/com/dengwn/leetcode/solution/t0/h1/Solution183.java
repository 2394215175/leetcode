package com.dengwn.leetcode.solution.t0.h1;

/**
 * @author: dengwn
 * @date: 2022-12-09
 **/
public class Solution183 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int index = 0;
        int size = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            } else {
                size++;
            }
        }
        for (int i = length - 1; i > size; i++) {
            nums[i] = 0;
        }
    }
}
