package com.dengwn.leetcode.solution.t1.h1.d7;

/**
 * @author: dengwn
 * @date: 2023-06-30
 **/
public class Solution1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] table = new int[10];
        for (String word : words) {
            table[f(word) - 1]++;
        }

        int[] prefix = new int[11];
        for (int i = 1; i < 11; i++) {
            prefix[i] = prefix[i - 1] + table[i - 1];
        }

        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = words.length - prefix[f(queries[i])];
        }
        return res;
    }

    public int f(String s) {
        int ans = 1;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < pre) {
                pre = c;
                ans = 1;
            } else if (c == pre) {
                ans++;
            }
        }
        return ans;
    }

}
