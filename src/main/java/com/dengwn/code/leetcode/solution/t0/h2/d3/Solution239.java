package com.dengwn.code.leetcode.solution.t0.h2.d3;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/12/12
 **/
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n + 1 - k];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1 - k, j = 0; j < n; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                ans[i] = deque.peekFirst();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(solution239.maxSlidingWindow(nums, k)));

    }
}
