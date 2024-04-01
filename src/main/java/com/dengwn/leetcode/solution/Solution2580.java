package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: dengwn
 * @date: 2024-03-27
 **/
public class Solution2580 {

    int MOD = 1000000007;

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int ans = 1;

        int max = -1;
        for (int[] range : ranges) {
            if (range[0] > max) {
                ans = ans * 2 % MOD;
            }
            if (range[1] > max) {
                max = range[1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2580 solution2580 = new Solution2580();
        int[][] ranges = {{34, 56}, {28, 29}, {12, 16}, {11, 48}, {28, 54}, {22, 55}, {28, 41}, {41, 44}};
        System.out.println(solution2580.countWays(ranges));
    }
}
