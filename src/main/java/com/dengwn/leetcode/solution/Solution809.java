package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-11-25
 **/
public class Solution809 {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isExpansion(word, s)) {
                count++;
            }
        }
        return count;
    }

    public boolean isExpansion(String word, String s) {
        int wLen = word.length();
        int sLen = s.length();
        if (wLen > sLen) {
            return false;
        }

        int i = 0;
        int j = 0;
        int countI = 0;
        int countJ = 0;
        while (i < sLen && j < wLen) {
            char c1 = s.charAt(i);
            char c2 = word.charAt(j);

            while (i < sLen) {
                if (c1 == s.charAt(i)) {
                    countI++;
                    i++;
                } else {
                    break;
                }
            }
            while (j < wLen) {
                if (c2 == word.charAt(j)) {
                    countJ++;
                    j++;
                } else {
                    break;
                }
            }
            if (c1 == c2) {
                if (countJ > countI) {
                    return false;
                }
                if (countI != countJ && countI == 2) {
                    return false;
                }
            } else {
                return false;
            }
            countI = 0;
            countJ = 0;
        }
        return i == sLen && j == wLen;
    }
}
