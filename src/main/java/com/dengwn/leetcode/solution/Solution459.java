package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-02-24
 **/
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
