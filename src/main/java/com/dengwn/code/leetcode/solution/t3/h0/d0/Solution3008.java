package com.dengwn.code.leetcode.solution.t3.h0.d0;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/11/14
 **/
public class Solution3008 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> list1 = kmpSearch(s, a);
        List<Integer> list2 = kmpSearch(s, b);
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            int si = list1.get(i);
            int sj = list2.get(j);
            if (Math.abs(si - sj) <= k) {
                ans.add(si);
                i++;
                continue;
            }
            if (sj <= si) {
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }

    public List<Integer> kmpSearch(String text, String pattern) {
        int[] matchTable = getMatchTable(pattern);
        int n = text.length();
        int m = pattern.length();
        int j = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = matchTable[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                list.add(i - m + 1);
                j = matchTable[j - 1];
            }
        }
        return list;
    }

    public int[] getMatchTable(String pattern) {
        int m = pattern.length();
        int[] table = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            char c = pattern.charAt(i);
            while (j > 0 && c != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (c == pattern.charAt(j)) {
                j++;
            }
            table[i] = j;
        }
        return table;
    }


    public static void main(String[] args) {
        Solution3008 solution3008 = new Solution3008();
        String s = "ababababazzabababb";
        String a = "aba";
        String b = "bb";
        int k = 10;
        System.out.println(solution3008.beautifulIndices(s, a, b, k));
    }
}
