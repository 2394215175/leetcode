package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2022-12-13
 */
public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        boolean[] booleans = new boolean[26];
        int res = sentence.length();
        for (int i = 0; i < sentence.length(); i++) {
            if (booleans[sentence.charAt(i) - 'a']) {
                res--;
            } else {
                booleans[sentence.charAt(i) - 'a'] = true;
            }
        }
        return res >= 26;
    }
}
