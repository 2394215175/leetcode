package com.dengwn.code.leetcode.solution.t1.h1.d8;

/**
 *
 * @author dengwenning
 * @since 2024/9/18
 **/
public class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        // 往左
        int a = 0;
        for (int i = start; i != destination; i++, i %= n) {
            a += distance[i];
        }
        int b = 0;
        for (int i = start; i != destination; i--, i += n, i %= n) {
            b += distance[(i - 1 + n) % n];
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        Solution1184 solution1184 = new Solution1184();
        int[] distance = new int[]{1, 2, 3, 4};
        int start = 0;
        int destination = 3;
        System.out.println(solution1184.distanceBetweenBusStops(distance, start, destination));
    }
}
