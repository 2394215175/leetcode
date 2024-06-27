package com.dengwn.leetcode.solution.t2.h3.d2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-02-01
 **/
public class Solution2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> dictionary = new HashMap<>();
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == ' ' || dictionary.containsKey(c)) {
                continue;
            }
            dictionary.put(c, (char) ('a' + index++));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            builder.append(dictionary.getOrDefault(message.charAt(i), ' '));
        }
        return builder.toString();
    }

    public String decodeMessage1(String key, String message) {
        char[] dictionary = new char[26];
        StringBuilder builder = new StringBuilder();

        char cur = 'a';
        char[] keys = key.toCharArray();
        for (char c : keys) {
            if (c != ' ' && dictionary[c - 'a'] == '\u0000') {
                dictionary[c - 'a'] = cur++;
            }
        }

        char[] messages = message.toCharArray();
        for (char c : messages) {
            if (c == ' ') {
                builder.append(' ');
            } else {
                builder.append(dictionary[c - 'a']);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        char[] dictionary = new char[26];
        for (int i = 0; i < dictionary.length; i++) {
            System.out.println(dictionary[i] == '\u0000');
        }
    }
}
