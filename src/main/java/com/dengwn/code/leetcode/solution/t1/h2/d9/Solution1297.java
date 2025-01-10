package com.dengwn.code.leetcode.solution.t1.h2.d9;

import java.util.HashMap;

/**
 *
 * @author dengwenning
 * @since 2025/1/4
 **/
public class Solution1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        for (int i = minSize; i <= maxSize; i++) {
            ans = Math.max(ans, maxFreq(s, maxLetters, i));
        }
        return ans;
    }

    public int maxFreq(String s, int k, int len) {
        int ans = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        HashMap<Character, Integer> cnt = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            cnt.merge(c, 1, Integer::sum);
            if (i + 1 < len) {
                continue;
            }
            if (cnt.size() <= k) {
                String sub = s.substring(i - len + 1, i + 1);
                memo.merge(sub, 1, Integer::sum);
                ans = Math.max(ans, memo.get(sub));
            }
            char d = s.charAt(i - len + 1);
            cnt.merge(d, -1, Integer::sum);
            if (cnt.get(d) == 0) {
                cnt.remove(d);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1297 solution1297 = new Solution1297();
        System.out.println(solution1297.maxFreq("aababcaab", 2, 3, 4));
    }
}
