package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2022-12-16
 */
public class Solution1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        double target = Math.abs(goal * 1.0 - sum);
        return (int) Math.ceil(target / limit);
    }

}



