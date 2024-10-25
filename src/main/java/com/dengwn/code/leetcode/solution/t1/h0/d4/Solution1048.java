package com.dengwn.code.leetcode.solution.t1.h0.d4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: dengwn
 * @date: 2023-04-27
 **/
public class Solution1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (words[i].length() - words[j].length() > 1) {
                    break;
                }
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public boolean isPredecessor(String pre, String cur) {
        int n = pre.length();
        int m = cur.length();
        if (m - n != 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        int diff = 0;
        while (i < n && j < m) {
            if (pre.charAt(i) == cur.charAt(j)) {
                i++;
            } else {
                diff++;
            }
            j++;
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1048 solution1048 = new Solution1048();
        String[] words = {"abcd", "dbqca"};
        System.out.println(solution1048.isPredecessor("abcd", "dbqca"));
        solution1048.longestStrChain(words);
    }
}
