package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2024-04-01
 **/
public class Solution2810 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'i'){
                sb.reverse();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
