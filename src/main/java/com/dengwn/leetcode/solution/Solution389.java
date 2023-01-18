package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution389 {
    public char findTheDifference(String s, String t) {
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            letter[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letter[i] != 0) {
                return (char) (i + 'a');
            }
        }
        return '0';
    }
}
