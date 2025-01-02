package com.dengwn.code.leetcode.solution.t0.h0.d5;

/**
 *
 * @author dengwenning
 * @since 2024/12/26
 **/
public class Solution58 {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int pre = n - 1;
        while (array[pre] == ' ') {
            pre--;
        }
        int end = pre;
        while (end >= 0 && array[end] != ' ') {
            end--;
        }
        return pre - end;
    }

    public static void main(String[] args) {
        Solution58 solution58 = new Solution58();
        System.out.println(solution58.lengthOfLastWord("Hello"));
    }
}
