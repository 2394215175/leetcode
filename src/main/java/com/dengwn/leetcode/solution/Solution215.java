package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dengwn
 * @date: 2023-04-27
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
