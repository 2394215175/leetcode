package com.dengwn.code.leetcode.solution.t1.h0.d0;

import java.util.Stack;

/**
 * @author: dengwn
 * @date: 2023-05-04
 **/
public class Solution1003 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'c') {
                if (stack.size() < 2) {
                    return false;
                }
                Character first = stack.pop();
                Character second = stack.pop();
                if (first != 'b' || second != 'a') {
                    return false;
                }
            } else {
                stack.add(aChar);
            }
        }
        return stack.empty();
    }
}
