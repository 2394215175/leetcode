package com.dengwn.code.leetcode.solution.t1.h0.d9;

/**
 * @author dengwenning
 * @since 2024/5/27
 **/
public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = 1002;
        int[] t = new int[n];
        for (int[] trip : trips) {
            t[trip[1]] += trip[0];
            t[trip[2]] -= trip[0];
        }
        int sum = 0;
        for (int i : t) {
            sum += i;
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1094 solution1094 = new Solution1094();
        int[][] trips = {{2, 1, 5}, {3, 5, 7}};
        System.out.println(solution1094.carPooling(trips, 3));

    }
}
