package com.dengwn.code.leetcode.solution.t0.h6.d3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/11/25
 **/
public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int[] ans = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Integer cur = nums.get(i).get(0);
            pq.add(new int[]{cur, i, 0});
            ans[0] = Math.min(ans[0], cur);
            ans[1] = Math.max(ans[1], cur);
            max = ans[1];
        }
        while (!pq.isEmpty() && pq.peek()[2] < nums.get(pq.peek()[1]).size() - 1) {
            int[] min = pq.poll();
            int i = min[1];
            int j = min[2] + 1;
            Integer next = nums.get(i).get(j);
            max = Math.max(max, next);
            pq.add(new int[]{next, i, j});
            if (max - pq.peek()[0] < ans[1] - ans[0]){
                ans[0] = pq.peek()[0];
                ans[1] = max;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution632 solution632 = new Solution632();
        List<List<Integer>> nums = Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(solution632.smallestRange(nums)));
    }
}
