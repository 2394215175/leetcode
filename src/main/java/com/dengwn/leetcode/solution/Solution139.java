package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-02-13
 **/
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(solution139.wordBreak(s, wordDict));
    }
}
