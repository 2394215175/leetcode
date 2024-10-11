package com.dengwn.leetcode.solution.t2.h1.d5;

/**
 *
 * @author dengwenning
 * @since 2024/9/30
 **/
public class Solution2156 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        char[] array = s.toCharArray();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = array[i] - 'a' + 1;
        }
        long mod = 1L;

        int ans = n - k;
        long modVal = 0;
        for (int i = n - k; i < n; i++) {
            modVal = (modVal + val[i] * mod) % modulo;
            if (i < n - 1) {
                mod = mod * power % modulo;
            }
        }
        for (int i = n - k - 1; i >= 0; i--) {
            modVal = (((modVal - val[i + k] * mod) % modulo * power) % modulo + val[i] + modulo) % modulo;
            if (modVal == hashValue) {
                ans = Math.min(ans, i);
            }
        }

        return s.substring(ans, ans + k);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int power = 7, modulo = 20, k = 2, hashValue = 0;

        Solution2156 solution = new Solution2156();
        System.out.println(solution.subStrHash(s, power, modulo, k, hashValue));

    }

}
