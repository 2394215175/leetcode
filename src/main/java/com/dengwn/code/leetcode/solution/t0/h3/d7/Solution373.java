package com.dengwn.code.leetcode.solution.t0.h3.d7;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2025/2/13
 **/
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        long mod = 100000L;
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        pq.add(new int[]{0, 0});
        List<List<Integer>> ans = new ArrayList<>();
        Set<Long> used = new HashSet<>();
        used.add(0L);
        while (k-- > 0 && !pq.isEmpty()) {
            int[] min = pq.poll();
            int i = min[0];
            int j = min[1];
            ans.add(Arrays.asList(nums1[i], nums2[j]));
            if (i + 1 < n && used.add((i + 1) * mod + j)) {
                pq.add(new int[]{i + 1, j});
            }
            if (j + 1 < m && used.add(i * mod + j + 1)) {
                pq.add(new int[]{i, j + 1});
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};
        Solution373 solution373 = new Solution373();
        System.out.println(solution373.kSmallestPairs(nums1, nums2, 20));
    }
}
