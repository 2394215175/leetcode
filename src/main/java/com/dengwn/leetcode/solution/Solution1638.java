package com.dengwn.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-03-27
 **/
public class Solution1638 {
    public int countSubstrings(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<String, Integer>[] maps = new Map[n];
        Map<String, Integer>[] mapt = new Map[m];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < m; i++) {
            mapt[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                String substring = s.substring(i, j);
                int index = substring.length() - 1;
                maps[index].merge(substring, 1, Integer::sum);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m + 1; j++) {
                String substring = t.substring(i, j);
                int index = substring.length() - 1;
                mapt[index].merge(substring, 1, Integer::sum);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map1 = maps[i];
            Map<String, Integer> map2 = mapt[i];
            for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
                for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                    if (isOnlyOneNoMatch(entry1.getKey(), entry2.getKey())) {
                        ans += entry1.getValue() * entry2.getValue();
                    }
                }
            }
        }

        return ans;
    }

    public boolean isOnlyOneNoMatch(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    public int countSubstrings1(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dpl = new int[m + 1][n + 1];
        int[][] dpr = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpl[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? (dpl[i][j] + 1) : 0;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dpr[i][j] = s.charAt(i) == t.charAt(j) ? (dpr[i + 1][j + 1] + 1) : 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    ans += (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution1638 solution1638 = new Solution1638();
        System.out.println(solution1638.countSubstrings1("abe", "bbc"));
    }
}
