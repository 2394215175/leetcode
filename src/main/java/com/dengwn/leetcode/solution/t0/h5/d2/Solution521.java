package com.dengwn.leetcode.solution.t0.h5.d2;

/**
 * @author dengwenning
 * @since 2024/6/16
 **/
public class Solution521 {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
