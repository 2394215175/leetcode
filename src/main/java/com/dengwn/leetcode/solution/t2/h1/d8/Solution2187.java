package com.dengwn.leetcode.solution.t2.h1.d8;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/10/10
 **/
public class Solution2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long max = Arrays.stream(time).max().getAsInt();
        long left = 0;
        long right = max * totalTrips;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] time, long ans, long totalTrips) {
        long sum = 0;
        for (int t : time) {
            sum += ans / t;
        }
        return sum >= totalTrips;
    }

    public static void main(String[] args) {
        Solution2187 solution2187 = new Solution2187();
        int[] time = new int[]{1, 2, 3};
        System.out.println(solution2187.minimumTime(time, 5));
    }
}
