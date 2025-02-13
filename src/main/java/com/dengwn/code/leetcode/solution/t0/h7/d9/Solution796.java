package com.dengwn.code.leetcode.solution.t0.h7.d9;


/**
 *
 * @author dengwenning
 * @since 2025/1/17
 **/
public class Solution796 {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }
        int[] nx = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            int v = goal.charAt(i);
            while (j > 0 && goal.charAt(j) != v) {
                j = nx[j - 1];
            }
            if (goal.charAt(j) == v) {
                j++;
            }
            nx[i] = j;
        }

        String t = s + s;
        for (int i = 0, j = 0; i < 2 * n; i++) {
            char v = t.charAt(i);
            while (j > 0 && v != goal.charAt(j)) {
                j = nx[j - 1];
            }
            if (v == goal.charAt(j)) {
                j++;
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution796 solution = new Solution796();
        System.out.println(solution.rotateString("defdefdefabcabc", "defdefabcabcdef"));
    }
}
