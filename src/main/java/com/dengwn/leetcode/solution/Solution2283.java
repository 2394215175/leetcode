package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-11
 **/
public class Solution2283 {
    public boolean digitCount(String num) {
        int[] nums = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            nums[i] += n;
            nums[n]--;

        }

        for (int j : nums) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}
