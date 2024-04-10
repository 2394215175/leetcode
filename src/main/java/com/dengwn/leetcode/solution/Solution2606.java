package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: dengwn
 * @date: 2024-04-03
 **/
public class Solution2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] table = new int[26];
        for (int i = 0; i < 26; i++) {
            table[i] = i + 1;
        }
        for (int i = 0; i < vals.length; i++) {
            table[chars.charAt(i) - 'a'] = vals[i];
        }

        int cur = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            cur = Math.max(cur + table[c - 'a'], table[c - 'a']);
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2606 solution2606 = new Solution2606();
        System.out.println(solution2606.maximumCostSubstring("abc", "abc", new int[]{-1, -1, -1}));
    }
}
