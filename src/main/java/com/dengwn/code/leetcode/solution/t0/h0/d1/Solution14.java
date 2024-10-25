package com.dengwn.code.leetcode.solution.t0.h0.d1;

/**
 * @author: dengwn
 * @date: 2022-12-09
 **/
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        boolean isOver = true;
        int index = 0;
        while (isOver) {
            char c = '1';
            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    isOver = false;
                    break;
                }
                if (c == '1') {
                    c = strs[i].charAt(index);
                }
                if (strs[i].charAt(index) != c) {
                    isOver = false;
                }
            }
            if (isOver) {
                index++;
            }
        }
        return strs[0].substring(0, index);
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] strs = {""};
        System.out.println(solution14.longestCommonPrefix(strs));
        System.out.println("".length());
    }
}
