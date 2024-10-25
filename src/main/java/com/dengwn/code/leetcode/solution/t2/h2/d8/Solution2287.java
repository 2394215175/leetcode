package com.dengwn.code.leetcode.solution.t2.h2.d8;

/**
 * @author: dengwn
 * @date: 2023-01-13
 **/
public class Solution2287 {
    public int rearrangeCharacters(String s, String target) {
        int n = s.length();
        int m = target.length();
        int[] chars = new int[26];
        int[] targets = new int[26];
        for (int i = 0; i < n; i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            targets[target.charAt(i) - 'a']++;
        }

        int ans = n;
        for (int i = 0; i < 26; i++) {
            if (targets[i] != 0) {
                ans = Math.min(ans, chars[i] / targets[i]);
            }
        }
        return ans;

    }
}
