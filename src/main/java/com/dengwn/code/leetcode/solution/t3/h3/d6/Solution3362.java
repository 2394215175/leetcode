package com.dengwn.code.leetcode.solution.t3.h3.d6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/11/25
 **/
public class Solution3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = nums.length;
        int m = queries.length;
        int[] cnt = new int[n + 1];
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sum += cnt[i];
            int cur = nums[i] - sum;
            while (j < m && queries[j][0] <= i) {
                pq.offer(queries[j][1]);
                j++;
            }
            while (!pq.isEmpty() && cur > 0 && pq.peek() >= i) {
                cur--;
                sum++;
                cnt[pq.poll() + 1]--;
            }
            if (cur > 0) {
                return -1;
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Solution3362 solution3362 = new Solution3362();
        int[] nums = {0, 0, 1, 1, 0};
        int[][] queries = {{3, 4}, {0, 2}, {2, 3}};
        System.out.println(solution3362.maxRemoval(nums, queries));
    }
}
