package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-13
 **/
public class Solution264 {
    int[] nums = {2, 3, 4, 5, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30};

    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        return (n - 1) / 22 * 30 + nums[(n - 1) % 22];
    }
}
