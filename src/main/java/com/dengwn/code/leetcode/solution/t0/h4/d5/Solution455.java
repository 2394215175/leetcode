package com.dengwn.code.leetcode.solution.t0.h4.d5;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2022-12-15
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1;
        int j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                ans++;
                i--;
                j--;
            } else {
                i--;
            }
        }
        return ans;
    }
}
