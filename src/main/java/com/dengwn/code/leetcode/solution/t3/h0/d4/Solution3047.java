package com.dengwn.code.leetcode.solution.t3.h0.d4;

/**
 *
 * @author dengwenning
 * @since 2025/1/7
 **/
public class Solution3047 {
    public boolean hasMatch(String s, String p) {
        int i = p.indexOf("*");
        int index1 = s.indexOf(p.substring(0, i));
        return index1 != -1 && s.substring(index1 + i).contains(p.substring(i + 1));
    }

    public static void main(String[] args) {
        Solution3047 solution3047 = new Solution3047();
        System.out.println(solution3047.hasMatch("luck", "u*"));
    }
}
