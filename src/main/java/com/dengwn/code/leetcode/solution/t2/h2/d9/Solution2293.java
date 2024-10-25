package com.dengwn.code.leetcode.solution.t2.h2.d9;

/**
 * @author: dengwn
 * @date: 2023-01-16
 **/
public class Solution2293 {
    public int minMaxGame(int[] nums) {
        while (nums.length != 1) {
            int[] newArr = new int[nums.length / 2];
            int index = 0;
            for (int i = 0; i < nums.length; i += 2) {
                newArr[index++] = i / 2 % 2 == 0 ? Math.min(nums[i], nums[i + 1]) : Math.max(nums[i], nums[i + 1]);
            }
            nums = newArr;
        }
        return nums[0];
    }
}
