package com.dengwn.code.leetcode.solution.t0.h2.d8;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution283 {
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
        while(size > 0){
            nums[length - size] = 0;
            size--;
        }
    }
}
