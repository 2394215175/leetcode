package com.dengwn.code.leetcode.solution.t0.h4.d5;

import java.util.ArrayDeque;

/**
 *
 * @author dengwenning
 * @since 2024/9/10
 **/
public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int k = Integer.MIN_VALUE;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                k = Math.max(k, deque.pollLast());
            }
            deque.addLast(nums[i]);
            if (nums[i] < k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution456 solution456 = new Solution456();
        System.out.println(solution456.find132pattern(new int[]{1,3,2,4,5,6,7,8,9,10}));
    }
}
