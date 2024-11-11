package com.dengwn.code.leetcode.solution.t1.h3.d9;

/**
 *
 * @author dengwenning
 * @since 2024/11/7
 **/
public class Solution1392 {
    public String longestPrefix(String s) {
        int[] next = new int[s.length()];
        // 求next数组
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        // 截取字符串
        return s.substring(0, next[s.length() - 1]);
    }

    public static void main(String[] args) {
        Solution1392 solution1392 = new Solution1392();
        System.out.println(solution1392.longestPrefix("leleel"));
    }
}
