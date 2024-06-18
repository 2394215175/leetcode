package com.dengwn.leetcode.solution.t2.h4.d2;

/**
 * @author: dengwn
 * @date: 2022-11-15
 **/
public class Solution2427 {
    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    public int commonFactors1(int a, int b) {
        if (a == b) {
            b = 0;
        }
        int count = 1;
        int diff = a > b ? a - b : b - a;
        for (int i = 2; i <= diff; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }
}
