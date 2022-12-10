package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: dengwn
 * @date: 2022-12-10
 **/
public class Solution346 {
}

class MovingAverage {
    int[] nums;
    int index;

    public MovingAverage(int size) {
        nums = new int[size];
        index = 0;
    }

    public double next(int val) {
        nums[index % nums.length] = val;
        index++;

        int sum = 0;
        int min = Math.min(nums.length, index);
        for (int i = 0; i < min; i++) {
            sum += nums[i];
        }
        return sum * 1.0 / min;
    }
}