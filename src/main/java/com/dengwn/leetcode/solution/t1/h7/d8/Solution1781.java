package com.dengwn.leetcode.solution.t1.h7.d8;

/**
 * @author dengwn
 * @date: 2022-12-12
 */
public class Solution1781 {
    public int beautySum(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int max = 0;
            int[] cnt = new int[26];
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                int min = s.length();
                if (cnt[s.charAt(j) - 'a'] > max) {
                    max = cnt[s.charAt(j) - 'a'];
                }
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0 && cnt[k] < min) {
                        min = cnt[k];
                    }
                }
                ans += (max - min);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1781 solution1781 = new Solution1781();
        System.out.println(solution1781.beautySum("aabcbaa"));
    }
}

// aabcbaa

//aab       1
//aabc      1
//aabcb     1
//aabcba    2
//aabcbaa   3

//abcb      1
//abcba     1
//abcbaa    2
//bcb       1
//bcba      1
//bcbaa     1
//cbaa      1
//baa       1
