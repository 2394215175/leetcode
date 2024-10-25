package com.dengwn.code.leetcode.solution.t1.h7.d0;


/**
 * @author: dengwn
 * @date: 2024-04-10
 **/
public class Solution1702 {
    public String maximumBinaryString(String binary) {
//        int first = -1;
//        int num = 0;
//        int n = binary.length();
//        for (int i = 0; i < n; i++) {
//            if (binary.charAt(i) == '0') {
//                if (first == -1) {
//                    first = i;
//                }
//                num++;
//            }
//        }
//
//        if (num == 0) {
//            return binary;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            sb.append(i == first + num ? '0' : '1');
//        }
//        return sb.toString();

        int n = binary.length();
        int i = binary.indexOf('0');
        if (i < 0) {
            return binary;
        }
        int cnt1 = i;
        char[] chars = binary.toCharArray();
        for (int j = i; j < n; j++) {
            cnt1 += chars[j] - '0';
            chars[j] = '1';
        }
        chars[i + n - cnt1 - 1] = '0';
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution1702 solution1702 = new Solution1702();
        System.out.println(solution1702.maximumBinaryString("1100"));
    }
}
