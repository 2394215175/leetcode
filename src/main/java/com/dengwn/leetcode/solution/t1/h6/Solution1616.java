package com.dengwn.leetcode.solution.t1.h6;

/**
 * @author dengwn
 * @date: 2023-03-18
 */
public class Solution1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b,a);
    }

    public boolean check(String a, String b) {
        int i = 0;
        int j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            // 前后缀尽量匹配
            ++i;
            --j;
        }
        return isOverString(a, i, j) || isOverString(b, i, j);
    }

    public boolean isOverString(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }
        return i >= j;
    }
}
