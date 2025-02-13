package com.dengwn.code.leetcode.solution.t3.h4.d4;

/**
 *
 * @author dengwenning
 * @since 2025/2/8
 **/
public class Solution3442 {
    public int maxDifference(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int a = 0;
        int b = n;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            if (cnt[i] % 2 == 0) {
                b = Math.min(b, cnt[i]);
            } else {
                a = Math.max(a, cnt[i]);
            }
        }
        return a - b;
    }
}
