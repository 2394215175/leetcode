package com.dengwn.leetcode.solution.t0.h1;

/**
 * @author: dengwn
 * @date: 2022-12-09
 **/
public class Solution143 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (word1.equals(wordsDict[i])) {
                index1 = i;
            }
            if (word2.equals(wordsDict[i])) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                ans = Math.min(Math.abs(index1 - index2), ans);
            }
        }
        return ans;
    }
}
