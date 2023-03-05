package com.dengwn.leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dengwn
 * @date: 2023-02-19
 */
public class Solution1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        Queue<double[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] > o2[2]) {
                return -1;
            } else if (o1[2] == o2[2]) {
                return 0;
            } else {
                return 1;
            }
        });

        for (int[] cla : classes) {
            double x = cla[0] * 1.0;
            double y = cla[1] * 1.0;
            queue.add(new double[]{x, y, (x + 1) / (y + 1) - x / y});
        }

        for (int i = extraStudents; i > 0; i--) {
            double[] cur = queue.poll();
            double nx = cur[0] + 1.0;
            double ny = cur[1] + 1.0;
            queue.add(new double[]{nx, ny, (nx + 1) / (ny + 1) - nx / ny});
        }

        double ans = 0.0;
        while (!queue.isEmpty()) {
            double[] cur = queue.poll();
            ans += cur[0] / cur[1];
        }
        return ans / n;
    }

    public static void main(String[] args) {
        Solution1792 solution1792 = new Solution1792();
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        System.out.println(solution1792.maxAverageRatio(classes, 2));
    }
}
