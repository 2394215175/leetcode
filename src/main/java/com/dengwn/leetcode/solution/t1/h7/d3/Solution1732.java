package com.dengwn.leetcode.solution.t1.h7.d3;

/**
 * @author: dengwn
 * @date: 2022-12-01
 **/
public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int pre = 0;
        for (int i : gain) {
            pre += i;
            if (pre > res) {
                res = pre;
            }
        }
        return res;
    }
}
