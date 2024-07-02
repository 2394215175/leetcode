package com.dengwn.leetcode.solution.t2.h7.d1;

/**
 * @author dengwenning
 * @since 2024/6/29
 **/
public class Solution2710 {
    public String removeTrailingZeros(String num) {
        char[] array = num.toCharArray();
        int n = num.length();
        int end = n;
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] != '0') {
                end = i;
                break;
            }
        }
        return num.substring(0, end + 1);
    }
}
