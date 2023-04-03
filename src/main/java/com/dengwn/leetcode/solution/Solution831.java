package com.dengwn.leetcode.solution;

import java.util.Locale;

/**
 * @author dengwn
 * @date: 2023-04-01
 */
public class Solution831 {
    public String maskPII(String s) {
        if (s.contains("@")) {
            s = s.toLowerCase();
            int index = s.indexOf("@");
            String old = s.substring(1, index - 1);
            return s.replaceFirst(old, "*****");
        } else {
            StringBuilder end = new StringBuilder("***-***-");
            int nums = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    nums++;
                    if (end.length() < 12) {
                        end.append(c);
                    }
                }
            }
            if (nums == 10) {
                return end.toString();
            }
            StringBuilder builder = new StringBuilder("+");
            for (int i = 10; i < nums; i++) {
                builder.append("*");
            }
            builder.append("-").append(end);
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Solution831 solution831 = new Solution831();
        System.out.println(solution831.maskPII("1(234)567-890"));
    }
}
