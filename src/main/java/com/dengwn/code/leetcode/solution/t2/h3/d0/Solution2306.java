package com.dengwn.code.leetcode.solution.t2.h3.d0;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/9/25
 **/
public class Solution2306 {
    public long distinctNames(String[] ideas) {
        Set<String>[] set = new Set[26];
        for (int i = 0; i < 26; i++) {
            set[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            char c = idea.charAt(0);
            set[c - 'a'].add(idea.substring(1));
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j){
                    continue;
                }
                long m = 0;
                for (String s : set[i]) {
                    if (set[j].contains(s)) {
                        m++;
                    }
                }
                ans += (set[i].size() - m) * (set[j].size() - m);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2306 solution2306 = new Solution2306();
        System.out.println(solution2306.distinctNames(new String[]{"uylydtf", "rgokcqubp", "w", "z", "msflnjy", "oni", "yylydtf", "t", "pni", "vq"}));
    }
}
