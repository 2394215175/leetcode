package com.dengwn.leetcode.solution.t0.h4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-02-01
 **/
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int len1 = s.length();
        int len2 = p.length();
        if(len1 < len2){
            return ans;
        }
        int[] res = new int[26];
        for (int i = 0; i < p.length(); i++) {
            res[p.charAt(i) - 'a']++;
        }

        int[] cur = new int[26];
        for (int i = 0; i < len2; i++) {
            cur[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cur, res)) {
            ans.add(0);
        }
        for (int i = 1; i < len1 - len2 + 1; i++) {
            cur[s.charAt(i - 1) - 'a']--;
            cur[s.charAt(i + len2 - 1) - 'a']++;
            if (Arrays.equals(cur, res)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        System.out.println(solution438.findAnagrams("aaaaaaaaaa",
                "aaaaaaaaaaaaa"));
    }
}
