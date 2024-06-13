package com.dengwn.leetcode.solution.t2.h3;

/**
 * @author dengwn
 * @date: 2023-01-01
 */
public class Solution2351 {
    public char repeatedCharacter(String s) {
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']++;
            if (chars[c - 'a'] > 1) {
                return c;
            }
        }
        return '0';
    }

}
