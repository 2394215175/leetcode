package com.dengwn.code.leetcode.solution.t3.h4.d3;

/**
 *
 * @author dengwenning
 * @since 2025/2/6
 **/
public class Solution3438 {
    public String findValidPair(String s) {
        int[] cnt = new int[10];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            cnt[s.charAt(i) - '0']++;
        }
        for (int i = 1; i < length; i++) {
            int pre = s.charAt(i - 1) - '0';
            int cur = s.charAt(i) - '0';
            if (pre != cur && cnt[pre] == pre && cnt[cur] == cur) {
                return s.substring(i - 1, i + 1);
            }
        }
        return "";
    }
}
