package com.dengwn.leetcode.solution.t0.h0;

/**
 * @author: dengwn
 * @date: 2024-03-07
 **/
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res < 2 || nums[i - 2] != nums[i]) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

}
