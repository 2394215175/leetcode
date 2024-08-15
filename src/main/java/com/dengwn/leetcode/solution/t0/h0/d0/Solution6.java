package com.dengwn.leetcode.solution.t0.h0.d0;

/**
 * @author dengwenning
 * @since 2024/8/8
 **/
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < array.length) {
                sb.append(array[j]);
                j += (numRows - 1) * 2;
                if (j - i * 2 < array.length && i != 0 && i != numRows - 1) {
                    sb.append(array[j - i * 2]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.convert(s, numRows));

    }
}
