package com.dengwn.leetcode.solution.t0.h3;

/**
 * @author dengwn
 * @date: 2023-01-08
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        int n = s.length();
        int pre = 0;
        for (int i = 0; i < n; i++) {
            chars[s.charAt(i) - 'a']++;
            while (pre < n && chars[s.charAt(pre) - 'a'] > 1) {
                pre++;
            }
        }
        return pre == n ? -1 : pre;
    }

    public static void main(String[] args) {
        Solution387 solution387 = new Solution387();
        System.out.println(solution387.firstUniqChar("leetcode"));
    }
}
