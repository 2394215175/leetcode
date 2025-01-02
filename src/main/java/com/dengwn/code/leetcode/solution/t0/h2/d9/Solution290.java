package com.dengwn.code.leetcode.solution.t0.h2.d9;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/27
 **/
public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> table1 = new HashMap<>();
        Map<String, Character> table2 = new HashMap<>();
        String[] ss = s.split(" ");
        int n = pattern.length();
        if (n != ss.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char pi = pattern.charAt(i);
            String si = ss[i];
            if (table1.containsKey(pi) && !table1.get(pi).equals(si)) {
                return false;
            }
            if (table2.containsKey(si) && table2.get(si) != pi) {
                return false;
            }
            table1.put(pi, si);
            table2.put(si, pi);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution290 solution290 = new Solution290();
        System.out.println(solution290.wordPattern("abba", "dog dog dog dog"));
    }
}
