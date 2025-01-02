package com.dengwn.code.leetcode.solution.t0.h0.d3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/27
 **/
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int m = words[0].length();
        int len = s.length();
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.merge(word, 1, Integer::sum);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i + n * m <= len; i++) {
            Map<String, Integer> cur = new HashMap<>();
            for (int j = 0; j < n * m; j += m) {
                String sub = s.substring(i + j, i + j + m);
                if (!cnt.containsKey(sub)) {
                    continue;
                }
                cur.merge(sub, 1, Integer::sum);
            }
            if (cur.equals(cnt)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        solution30.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
    }
}
