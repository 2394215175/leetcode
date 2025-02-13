package com.dengwn.code.leetcode.solution.t0.h0.d8;

/**
 * @author: dengwn
 * @date: 2024-03-07
 **/
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res < 2 || nums[res - 2] != nums[i]) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        System.out.println(solution80.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

}
