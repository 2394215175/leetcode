package com.dengwn.leetcode.solution.t1.h6;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
