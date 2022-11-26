package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-11-24
 **/
public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int sum = 0;
        int quaVal = 0;
        int lessVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                quaVal = 0;
                lessVal = 0;
            } else if (nums[i] >= left) {
                lessVal++;
                quaVal = lessVal;
                sum += lessVal;
            } else {
                lessVal++;
                sum += quaVal;
            }
        }
        return sum;
    }
}
