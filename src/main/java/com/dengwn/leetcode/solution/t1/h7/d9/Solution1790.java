package com.dengwn.leetcode.solution.t1.h7.d9;

/**
 * @author: dengwn
 * @date: 2022-12-29
 **/
public class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int diff = 0;
        int[] chars = new int[26];
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                diff++;
                chars[c1 - 'a']++;
                chars[c2 - 'a']--;
            }
        }
        if (diff == 0) {
            return true;
        }
        if (diff == 2) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
