package com.dengwn.code.leetcode.solution.t3.h2.d6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/12/13
 **/
public class Solution3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
        }
        while (k-- > 0) {
            int[] poll = pq.poll();
            poll[0] *= multiplier;
            pq.add(poll);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] poll = pq.poll();
            ans[poll[1]] = poll[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3264 solution3264 = new Solution3264();
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        System.out.println(Arrays.toString(solution3264.getFinalState(nums, k, multiplier)));
    }
}
