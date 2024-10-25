package com.dengwn.code.leetcode.solution.t1.h2.d0;

/**
 *
 * @author dengwenning
 * @since 2024/9/30
 **/
public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] dict = new int[n];
        for (int i = 0; i < n; i++) {
            dict[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int ans = 0;
        int left = 0;
        int cost = 0;
        for (int right = 0; right < n; right++) {
            cost += dict[right];
            while (cost > maxCost) {
                cost -= dict[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
