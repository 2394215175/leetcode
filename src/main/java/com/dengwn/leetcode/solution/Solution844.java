package com.dengwn.leetcode.solution;

import java.util.Stack;

/**
 * @author: dengwn
 * @date: 2023-01-31
 **/
public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack1.empty() && c == '#') {
                stack1.pop();
            }
            if (c != '#') {
                stack1.add(c);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!stack2.empty() && c == '#') {
                stack2.pop();
            }
            if (c != '#') {
                stack2.add(c);
            }
        }
        return stack1.equals(stack2);
    }
}
