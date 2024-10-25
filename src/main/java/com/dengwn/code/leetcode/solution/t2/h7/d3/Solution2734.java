package com.dengwn.code.leetcode.solution.t2.h7.d3;

import java.util.Map;

/**
 * @author dengwenning
 * @since 2024/6/27
 **/
public class Solution2734 {
    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = -1;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'a' && start != -1) {
                break;
            }
            if (chars[i] != 'a') {
                end = Math.max(end, i);
                if (start == -1) {
                    start = i;
                }
            }
        }
        if (start != -1) {
            for (int i = start; i <= end; i++) {
                chars[i] -= 1;
            }
        } else {
            chars[n - 1] = 'z';
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution2734 solution2734 = new Solution2734();
        System.out.println(solution2734.smallestString("aa"));
    }
}
