package com.dengwn.code.leetcode.solution.t2.h9.d3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/12/12
 **/
public class Solution2931 {
    public long maxSpending(int[][] values) {
        int n = values.length;
        int m = values[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> values[o[0]][o[1]]));
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, m - 1});
        }
        long ans = 0;
        long d = 1;
        while (!queue.isEmpty()) {
            int[] min = queue.poll();
            int i = min[0];
            int j = min[1];
            ans += values[i][j] * d;
            if (j > 0) {
                queue.add(new int[]{i, j - 1});
            }
            d++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] values = {{8, 5, 2}, {6, 4, 1}, {9, 7, 3}};
        Solution2931 solution2931 = new Solution2931();
        System.out.println(solution2931.maxSpending(values));

    }
}
