package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-06-30
 **/
public class Solution2490 {
    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].charAt(strs[i].length() - 1) != strs[(i + 1) % n].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
