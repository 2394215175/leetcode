package com.dengwn.code.leetcode.solution.t0.h6.d8;

/**
 *
 * @author dengwenning
 * @since 2024/11/14
 **/
public class Solution686 {
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] pi = new int[m];
        int c = 0;
        for (int i = 1; i < m; i++) {
            char v = b.charAt(i);
            while (c > 0 && b.charAt(c) != v) {
                c = pi[c - 1];
            }
            if (b.charAt(c) == v) {
                c++;
            }
            pi[i] = c;
        }

        c = 0;
        for (int i = 0; i < (m / n + 2) * n; i++) {
            char u = a.charAt(i % n);
            while (c > 0 && b.charAt(c) != u) {
                c = pi[c - 1];
            }
            if (b.charAt(c) == u) {
                c++;
            }
            if (c == m) {
                return (i + n) / n;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution686 solution686 = new Solution686();
        String a = "abc";
        String b = "cabcabca";
        System.out.println(solution686.repeatedStringMatch(a, b));
    }
}
