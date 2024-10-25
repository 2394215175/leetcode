package com.dengwn.code.leetcode.solution.t0.h4;

/**
 * @author: dengwn
 * @date: 2023-02-24
 **/
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
