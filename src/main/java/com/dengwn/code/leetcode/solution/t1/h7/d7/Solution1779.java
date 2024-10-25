package com.dengwn.code.leetcode.solution.t1.h7.d7;

/**
 * @author: dengwn
 * @date: 2022-12-01
 **/
public class Solution1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int distance = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int newDistance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (newDistance < distance) {
                    distance = newDistance;
                    res = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        Solution1779 solution1779 = new Solution1779();
        int i = solution1779.nearestValidPoint(3, 4, points);
        System.out.println(i);
    }
}
