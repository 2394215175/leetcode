package com.dengwn.code.leetcode.solution.t0.h3.d4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/12/25
 **/
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (queue.size() < k) {
                queue.add(new int[]{key, value});
            } else if (value > queue.peek()[1]) {
                queue.poll();
                queue.add(new int[]{key, value});
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll()[0];
        }
        return ans;
    }
}
