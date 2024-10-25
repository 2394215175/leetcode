package com.dengwn.code.leetcode.solution.t0.h3;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution344 {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
    }
}
