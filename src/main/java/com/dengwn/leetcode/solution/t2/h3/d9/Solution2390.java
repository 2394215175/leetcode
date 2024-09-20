package com.dengwn.leetcode.solution.t2.h3.d9;

/**
 *
 * @author dengwenning
 * @since 2024/9/14
 **/
public class Solution2390 {
    public String removeStars(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
