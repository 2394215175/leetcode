package com.dengwn.code.leetcode.solution.t0.h4.d5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author dengwenning
 * @since 2024/12/31
 **/
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Stack<String> stack = new Stack<>();
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int preEnd = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > preEnd) {
                ans++;
                preEnd = point[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution452 solution = new Solution452();
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(solution.findMinArrowShots(points));


    }
}
