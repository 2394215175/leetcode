package com.dengwn.leetcode.solution.t2.h4.d1;

/**
 *
 * @author dengwenning
 * @since 2024/9/19
 **/
public class Solution2414 {
    public int longestContinuousSubstring(String s) {
        char[] array = s.toCharArray();
        int n = s.length();
        int ans = 1;
        int left = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] - array[i - 1] == 1) {
                if (i - left + 1 > ans) {
                    ans = i - left + 1;
                }
            } else {
                left = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2414 solution2414 = new Solution2414();
        System.out.println(solution2414.longestContinuousSubstring("abacaba"));
    }
}
