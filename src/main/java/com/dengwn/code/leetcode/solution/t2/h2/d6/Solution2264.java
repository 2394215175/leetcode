package com.dengwn.code.leetcode.solution.t2.h2.d6;

/**
 *
 * @author dengwenning
 * @since 2025/1/8
 **/
public class Solution2264 {
    public String largestGoodInteger(String num) {
        int n = num.length();
        char[] array = num.toCharArray();
        char max = 0;
        char pre = ' ';
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (array[i] == pre) {
                cnt++;
            } else {
                pre = array[i];
                cnt = 1;
            }
            if (cnt == 3 && array[i] > max) {
                max = array[i];
            }
        }
        return max == 0 ? "" : "" + max + max + max;
    }
}
