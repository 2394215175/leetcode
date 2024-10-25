package com.dengwn.code.leetcode.solution.t1.h9.d4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author dengwenning
 * @since 2024/6/29
 **/
public class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> t = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int nums = 0;
            while (!t.isEmpty()) {
                if (heights[i] > t.peek()) {
                    t.poll();
                    nums++;
                } else {
                    nums++;
                    break;
                }
            }
            t.addFirst(heights[i]);
            ans[i] = nums;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution1944 solution1944 = new Solution1944();
        int[] heights = {10, 6, 8, 5, 11, 9};
        System.out.println(Arrays.toString(solution1944.canSeePersonsCount(heights)));
    }
}
