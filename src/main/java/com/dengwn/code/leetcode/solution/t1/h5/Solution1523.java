package com.dengwn.code.leetcode.solution.t1.h5;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution1523 {
    public int countOdds(int low, int high) {
        return (high + 1 >> 1) - (low >> 1);
    }
    public int countOdds1(int low, int high) {
        return low % 2 + high % 2 == 2 ? 1 + (high - low) / 2 : low % 2 + high % 2 + (high - low) / 2;
    }
}
