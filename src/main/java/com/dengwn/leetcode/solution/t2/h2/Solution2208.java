package com.dengwn.leetcode.solution.t2.h2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-07-25
 **/
public class Solution2208 {
    public int halveArray(int[] nums) {
        Queue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());

        double sum = 0;
        for (int num : nums) {
            queue.add((double) num);
            sum += num;
        }

        int step = 0;
        double diff = 0.0;
        while (diff < sum / 2) {
            Double max = queue.poll();
            double v = max / 2;
            diff += v;
            queue.add(v);
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {32, 98, 23, 14, 67, 40, 26, 9, 96, 96, 91, 76, 4, 40, 42, 2, 31, 13, 16, 37, 62, 2, 27, 25, 100, 94, 14, 3, 48, 56, 64, 59, 33, 10, 74, 47, 73, 72, 89, 69, 15, 79, 22, 18, 53, 62, 20, 9, 76, 64};
        Solution2208 solution2208 = new Solution2208();
        System.out.println(solution2208.halveArray(nums));

    }
}
