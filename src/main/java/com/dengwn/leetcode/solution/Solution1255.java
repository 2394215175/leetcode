package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2023-02-26
 */
public class Solution1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char letter : letters) {
            count[letter - 'a']++;
        }
        int n = words.length;
        int ans = 0;
        for (int i = 1; i < (1 << n); i++) {
            StringBuilder s = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if ((i & (1 << k)) != 0) {
                    // words[k] 不在子集 s 中
                    s.append(words[k]);
                }
            }

            ans = Math.max(ans, calc(s.toString().toCharArray(), count, score));
        }
        return ans;
    }

    public int calc(char[] chars, int[] count, int[] score) {
        int ans = 0;
        int[] copy = Arrays.copyOf(count, count.length);
        for (char c : chars) {
            if (--copy[c - 'a'] < 0) {
                return -1;
            }
            ans += score[c - 'a'];
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution1255 solution1255 = new Solution1255();
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


//        String[] words = {'xxxz', 'ax', 'bx', 'cx'};
//        char[] letters = {'z', 'a', 'b', 'c', 'x', 'x', 'x'};
//        int[] score = {4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};

//
//        String[] words = {"leetcode"};
//        char[] letters = {'l', 'e', 't', 'c', 'o', 'd'};
//        int[] score = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};


//        String[] words = {"baaa", "aacc", "ccbc", "da", "dbbc"};
//        char[] letters = {'a', 'a', 'a', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd'};
//        int[] score = {9, 4, 10, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(solution1255.maxScoreWords(words, letters, score));
    }
}
