package com.dengwn.leetcode.solution.t1.h2;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int preX = coordinates[0][0];
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i][0] != preX) {
                break;
            }
            if (i == coordinates.length - 1 && coordinates[i][0] == preX) {
                return true;
            }
        }
        int[] first = coordinates[0];
        int[] second = coordinates[1];
        int xDiff = second[0] - first[0];
        int yDiff = second[1] - first[1];
        for (int i = 2; i < coordinates.length; i++) {
            if (yDiff * 1.0 / xDiff * (coordinates[i][0] - first[0]) + first[1] != coordinates[i][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = {{0, 0}, {0, 1}, {0, -1}};
        Solution1232 solution1232 = new Solution1232();
        System.out.println(solution1232.checkStraightLine(coordinates));
    }
}
