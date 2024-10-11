package com.dengwn.leetcode.solution.t1.h8.d8;

/**
 *
 * @author dengwenning
 * @since 2024/9/30
 **/
public class Solution1888 {

    public int minFlips(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int q0 = 0, q1 = 0;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                // 偶数位
                q0 += array[i] == '0' ? 1 : 0;
                q1 += array[i] == '1' ? 1 : 0;
            } else {
                p0 += array[i] == '0' ? 1 : 0;
                p1 += array[i] == '1' ? 1 : 0;
            }
        }
        int ans = Math.min(q0 + p1, p0 + q1);
        if ((n & 1) == 0) {
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                if (array[i] == '0') {
                    q0--;
                    p0++;
                } else {
                    q1--;
                    p1++;
                }
            } else {
                if (array[i] == '0') {
                    p0--;
                    q0++;
                } else {
                    p1--;
                    q1++;
                }
            }
            ans = Math.min(ans, Math.min(q0 + p1, p0 + q1));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1888 solution1888 = new Solution1888();
        System.out.println(solution1888.minFlips("01001001101"));
    }
}
