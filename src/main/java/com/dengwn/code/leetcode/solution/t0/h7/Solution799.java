package com.dengwn.code.leetcode.solution.t0.h7;

/**
 * @author: dengwn
 * @date: 2022-12-02
 **/
public class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] triangle = new double[query_row + 1][query_row + 2];
        triangle[0][1] = poured;
        for (int i = 1; i < query_row + 1; i++) {
            for (int j = 1; j < i + 2; j++) {
                triangle[i][j] = (Math.max(triangle[i - 1][j - 1] - 1, 0) / 2.0) + (Math.max(triangle[i - 1][j] - 1, 0) / 2.0);
            }
        }
        return Math.min(1, triangle[query_row][query_glass + 1]);
    }

    public static void main(String[] args) {
        Solution799 solution799 = new Solution799();
        System.out.println(solution799.champagneTower(25, 6, 1));
    }
}
