package com.dengwn.leetcode.solution.t2.h1.d8;

/**
 * @author dengwn
 * @date: 2023-01-08
 */
public class Solution2185 {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if(word.startsWith(pref)){
                ans++;
            }
        }
        return ans;
    }
}
