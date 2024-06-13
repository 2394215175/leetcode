package com.dengwn.leetcode.solution.t0.h0;

/**
 * @author: dengwn
 * @date: 2023-02-13
 **/
public class Solution91 {
    public int numDecodings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (chars[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && chars[i - 2] != '0' && (chars[i - 2] - '0') * 10 + chars[i - 1] - '0' <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        System.out.println(solution91.numDecodings("056"));
    }
}
