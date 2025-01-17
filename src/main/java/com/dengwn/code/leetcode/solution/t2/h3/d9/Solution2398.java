package com.dengwn.code.leetcode.solution.t2.h3.d9;


import java.util.ArrayDeque;

/**
 *
 * @author dengwenning
 * @since 2024/9/14
 **/
public class Solution2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int ans = 0;
        int left = 0;
        int right = 0;
        long sum = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (; right < n; right++) {
            queue.add(chargeTimes[right]);
            sum += runningCosts[right];
        }

        return left;
    }

    public static void main(String[] args) {
        Solution2398 solution = new Solution2398();

        int[] chargeTimes = {74, 46, 19, 34, 7, 87, 7, 40, 28, 81, 53, 39, 3, 46, 21, 40, 76, 44, 88, 93, 44, 50, 22, 59, 46, 60, 36, 24, 50, 40, 56, 5, 39, 9, 24, 74, 7, 14, 95, 45, 36, 17, 22, 12, 53, 41, 2, 33, 100, 73, 20, 70, 81, 91, 28, 98, 47, 88, 79, 100, 78, 38, 44, 74, 48, 76, 73, 92, 28, 30, 95, 87};
        int[] runningCosts = {11, 33, 15, 40, 8, 28, 97, 89, 51, 42, 17, 57, 45, 5, 63, 53, 23, 43, 76, 64, 86, 86, 89, 53, 94, 91, 78, 12, 90, 29, 79, 48, 35, 6, 88, 79, 82, 76, 44, 93, 83, 55, 65, 96, 86, 24, 54, 65, 94, 4, 26, 73, 51, 85, 47, 99, 17, 14, 76, 2, 39, 52, 58, 5, 15, 35, 79, 16, 94, 16, 59, 50};
        int budget = 447;
        System.out.println(solution.maximumRobots(chargeTimes, runningCosts, budget));

    }
}
