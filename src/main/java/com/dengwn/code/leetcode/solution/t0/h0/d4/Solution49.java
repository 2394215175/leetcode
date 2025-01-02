package com.dengwn.code.leetcode.solution.t0.h0.d4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/12
 **/
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = new char[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            String key = new String(chars);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }

        return new ArrayList<>(map.values());
    }
}
