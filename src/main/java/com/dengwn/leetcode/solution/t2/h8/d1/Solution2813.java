package com.dengwn.leetcode.solution.t2.h8.d1;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/13
 **/
public class Solution2813 {
    public long findMaximumElegance(int[][] items, int k) {
        int n = items.length;
        // 重复类别
        PriorityQueue<Integer> repeat = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        long res = 0;
        long totalProfit = 0;
        Arrays.sort(items, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            int profit = items[i][0];
            int category = items[i][1];
            // 前k个值直接加入
            if (i < k) {
                if (!set.add(category)) {
                    repeat.add(profit);
                }
                totalProfit += profit;
            } else {
                // 如果当前类型已经在集合中，不会使distinctCategories变大，跳过
                if (set.contains(category)) {
                    continue;
                }
                // 没有重复的，只会使totalProfit变小，跳过
                if (repeat.isEmpty()) {
                    continue;
                }
                // 有重复的，并且之前类型不在集合中，使totalProfit变小，但是会使distinctCategories变大
                totalProfit += profit - repeat.poll();
                set.add(category);
            }
            long size = set.size();
            res = Math.max(res, totalProfit + size * size);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] items = {{1, 2}, {10, 1}};
        int k = 1;
        Solution2813 solution2813 = new Solution2813();
        System.out.println(solution2813.findMaximumElegance(items, k));


    }
}
