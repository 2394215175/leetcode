package com.dengwn.code.leetcode.solution.t0.h1.d5;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author dengwenning
 * @since 2025/2/13
 **/
public class Solution150 {
    public int evalRPN(String[] tokens) {
        List<String> type = Arrays.asList("+", "-", "*", "/");
        int[] nums = new int[tokens.length];
        int i = 0;
        for (String token : tokens) {
            if (type.contains(token)) {
                int b = nums[i - 1];
                int a = nums[i - 2];
                nums[i - 2] = calc(a, b, token);
                i--;
            } else {
                nums[i] = Integer.parseInt(token);
                i++;
            }
        }
        return nums[0];
    }

    public int calc(int a, int b, String t) {
        if (t.equals("+")) {
            return a + b;
        } else if (t.equals("-")) {
            return a - b;
        } else if (t.equals("*")) {
            return a * b;
        } else if (t.equals("/")) {
            return a / b;
        }
        return -1;
    }
}
