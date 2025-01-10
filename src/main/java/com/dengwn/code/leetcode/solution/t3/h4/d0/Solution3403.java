package com.dengwn.code.leetcode.solution.t3.h4.d0;

/**
 *
 * @author dengwenning
 * @since 2025/1/3
 **/
public class Solution3403 {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String ans = "";
        int n = word.length();
        for (int i = 0; i < n; i++) {
            String sub = word.substring(i, Math.min(n - numFriends + 1 + i, n));
            if (sub.compareTo(ans) >= 0) {
                ans = sub;
            }
        }
        return ans;
    }
}
