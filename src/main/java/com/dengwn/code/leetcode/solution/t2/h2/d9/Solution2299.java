package com.dengwn.code.leetcode.solution.t2.h2.d9;

/**
 * @author: dengwn
 * @date: 2023-01-19
 **/
public class Solution2299 {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) {
            return false;
        }
        boolean b1 = false, b2 = false, b3 = false, b4 = false;
        char pre = '=';
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (pre == c) {
                return false;
            }
            pre = c;
            if (c >= 'a' && c <= 'z') {
                b1 = true;
            } else if (c >= 'A' && c <= 'Z') {
                b2 = true;
            } else if (c >= '0' && c <= '9') {
                b3 = true;
            } else {
                b4 = true;
            }
        }
        return b1 && b2 && b3 && b4;
    }
}
