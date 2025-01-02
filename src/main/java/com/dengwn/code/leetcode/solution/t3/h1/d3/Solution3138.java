package com.dengwn.code.leetcode.solution.t3.h1.d3;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/12/23
 **/
public class Solution3138 {
    public int minAnagramLength(String s) {
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            if (check(s.toCharArray(), n / i)) {
                return i;
            }
        }
        return n;
    }

    public boolean check(char[] s, int k) {
        int[][] cnt = new int[k][26];
        int n = s.length;
        for (int i = 0; i < n; i++) {
            cnt[i / (n / k)][s[i] - 'a']++;
        }
        for (int i = 0; i < k; i++) {
            if (!Arrays.equals(cnt[0], cnt[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution3138 solution3138 = new Solution3138();
        System.out.println(solution3138.minAnagramLength("aabb"));
    }

}
