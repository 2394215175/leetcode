package com.dengwn.leetcode.solution.t2.h5.d1;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/9/27
 **/
public class Solution2516 {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] diff = new int[3];
        Arrays.fill(diff, -k);
        for (int i = 0; i < n; i++) {
            diff[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            if (diff[i] < 0) {
                return -1;
            }
        }
        int res = 0;
        int left = 0;
        int[] cnt = new int[3];
        for (int right = 0; right < n; right++) {
            int c = s.charAt(right) - 'a';
            cnt[c]++;
            while (cnt[c] > diff[c]) {
                cnt[s.charAt(left++) - 'a']--;
            }
            res = Math.max(res, right - left + 1);
        }
        return n - res;
    }

    public static void main(String[] args) {
        Solution2516 solution = new Solution2516();
        System.out.println(solution.takeCharacters("aabaaaacaabc", 2));
    }
}
