package com.dengwn.code.leetcode.solution.t1.h8.d2;

/**
 * @author dengwn
 * @date: 2022-12-11
 */
public class Solution1827 {
    public int minOperations(int[] nums) {
        int pre = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                pre = nums[i];
            } else {
                pre = pre + 1;
                ans = ans + pre - nums[i];
            }
        }
        return ans;
    }
}
