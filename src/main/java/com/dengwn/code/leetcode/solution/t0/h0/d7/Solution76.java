package com.dengwn.code.leetcode.solution.t0.h0.d7;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/13
 **/
public class Solution76 {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int ansLeft = -1;
        int ansRight = n;
        int[] target = new int[128];
        for (char c : t.toCharArray()) {
            target[c]++;
        }
        int[] cnt = new int[128];
        int left = 0;
        char[] array = s.toCharArray();
        for (int right = 0; right < n; right++) {
            cnt[array[right]]++;
            if (right - left + 1 >= m) {
                while (check(cnt, target)) {
                    if (right - left < ansRight - ansLeft) {
                        ansLeft = left;
                        ansRight = right;
                    }
                    cnt[array[left++]]--;
                }
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    public boolean check(int[] source, int[] target) {
        for (int i = 0; i < 128; i++) {
            if (source[i] < target[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        Solution76 solution76 = new Solution76();
        String s1 = solution76.minWindow(s, t);
        System.out.println(s1);
    }
}
