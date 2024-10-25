package com.dengwn.code.leetcode.solution.t0.h9;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dictionary = new int[27];
        int n = words.length;
        dictionary[26] = Integer.MIN_VALUE;
        for (int i = 0; i < order.length(); i++) {
            dictionary[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < n; i++) {
            if (!isSort(dictionary, words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isSort(int[] dictionary, String word1, String word2) {
        int index = 0;
        while (index < word1.length() || index < word2.length()) {
            int cur1 = dictionary[26];
            int cur2 = dictionary[26];
            if (index < word1.length()) {
                cur1 = dictionary[word1.charAt(index) - 'a'];
            }
            if (index < word2.length()) {
                cur2 = dictionary[word2.charAt(index) - 'a'];
            }
            if (cur1 > cur2) {
                return false;
            } else if (cur1 == cur2) {
                index++;
            } else {
                return true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        Solution953 solution953 = new Solution953();
        System.out.println(solution953.isAlienSorted(words, order));
    }
}
