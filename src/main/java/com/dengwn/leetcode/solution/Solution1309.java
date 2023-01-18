package com.dengwn.leetcode.solution;

import java.util.Stack;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution1309 {
    public String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                builder.append((char) (Integer.parseInt(s.substring(i, i + 2)) - 10 + 'j'));
            } else {
                builder.append((char) (s.charAt(i) - '1' + 'a'));
            }
        }
        return builder.toString();
    }
}
