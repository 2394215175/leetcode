package com.dengwn.code.leetcode.solution.t1.h7.d6;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int n = word1.length();
        int m = word2.length();
        int index = 0;
        while (index < n && index < m) {
            builder.append(word1.charAt(index)).append(word2.charAt(index));
            index++;
        }
        builder.append(word1, index, n).append(word2, index, m);
        return builder.toString();
    }
}
