package com.dengwn.leetcode.solution.t1.h7;

/**
 * @author dengwn
 * @date: 2022-11-29
 */
public class Solution1758 {
    public int minOperations(String s) {
        int length = s.length();
        int cnt = 0;

        for (int i = 0; i < length; i++) {
            if ((s.charAt(i) == '1') ^ (i % 2 == 1)) {
                cnt++;
            }
        }

        return Math.min(cnt, length - cnt);
    }

    public static void main(String[] args) {
        Solution1758 solution1758 = new Solution1758();
        System.out.println(solution1758.minOperations("0100"));
    }
}
