package com.dengwn.leetcode.solution.t0.h5.d2;

/**
 * @author dengwenning
 * @since 2024/6/17
 **/
public class Solution522 {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() < ans) {
                continue;
            }
            boolean isSub = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsequence(strs[i], strs[j])) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                ans = strs[i].length();
            }
        }
        return ans;
    }

    private boolean isSubsequence(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s1.length();
    }
}
