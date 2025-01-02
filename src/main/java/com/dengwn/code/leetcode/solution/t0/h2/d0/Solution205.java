package com.dengwn.code.leetcode.solution.t0.h2.d0;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/27
 **/
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> table1 = new HashMap<>();
        Map<Character, Character> table2 = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (!table1.containsKey(si) && !table2.containsKey(ti)) {
                table1.put(si, ti);
                table2.put(ti, si);
            } else {
                if (table1.getOrDefault(si, ' ') != ti || table2.getOrDefault(ti, ' ') != si) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution205 solution = new Solution205();
        System.out.println(solution.isIsomorphic("foo", "bar"));
    }
}
