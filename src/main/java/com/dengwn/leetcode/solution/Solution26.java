package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-12-05
 **/
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res < 1 || nums[i - 1] != nums[i]) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = {1, 1, 2};
        System.out.println(solution26.removeDuplicates(nums));
    }
}
