package com.dengwn.leetcode.solution.t2.h4.d8;

/**
 * @author: dengwn
 * @date: 2023-06-27
 **/
public class Solution2485 {
    public int pivotInteger(int n) {
        int t = (n * n + n) / 2;
        int ans = (int) Math.sqrt(t);
        if (ans * ans == t) {
            return ans;
        }
        return -1;
    }
}
