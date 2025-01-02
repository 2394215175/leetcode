package com.dengwn.code.leetcode.solution.t0.h0.d2;

import java.util.LinkedList;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution20 {
    public boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')' || c == '}' || c == ']') {
                if (queue.isEmpty()) {
                    return false;
                }
                char top = queue.pop();
                if (!isMatch(top, c)) {
                    return false;
                }
            } else {
                queue.push(c);
            }
        }
        return queue.isEmpty();
    }

    public boolean isMatch(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return left == '[' && right == ']';
    }

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        System.out.println(solution.isValid("([])"));
    }
}
