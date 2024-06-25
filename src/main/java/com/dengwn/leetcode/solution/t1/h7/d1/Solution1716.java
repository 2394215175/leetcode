package com.dengwn.leetcode.solution.t1.h7.d1;

/**
 * @author: dengwn
 * @date: 2022-11-16
 **/
public class Solution1716 {
    public int totalMoney(int n) {
        int x = n / 7;
        int y = n % 7;
        return (7 * x * x + 49 * x + 2 * x * y + y * y + y) / 2;
    }
}
