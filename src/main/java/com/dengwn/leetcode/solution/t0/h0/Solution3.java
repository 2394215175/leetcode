package com.dengwn.leetcode.solution.t0.h0;

import java.util.HashMap;

/**
 * @author: dengwn
 * @date: 2022-12-28
 **/
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                ans = Math.max(ans, i - pre);
                pre = Math.max(map.get(c) + 1, pre);
            }
            map.put(c, i);
            if (i == s.length() - 1) {
                ans = Math.max(ans, i + 1 - pre);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("abba"));
    }
}
