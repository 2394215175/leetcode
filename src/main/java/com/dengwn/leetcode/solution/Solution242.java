package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] dictionary = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dictionary[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            dictionary[s.charAt(i) - 'a']--;
        }
        for (int i : dictionary) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
