package com.dengwn.code.leetcode.solution.t0.h4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwn
 * @date: 2022-12-14
 */
public class Solution422 {
    public boolean validWordSquare(List<String> words) {
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(word.length(), maxLen);
        }
        if (words.size() != maxLen) {
            return false;
        }
        char[][] matrix = new char[words.size()][maxLen];
        for (int i = 0; i < words.size(); i++) {
            String s = words.get(i);
            for (int j = 0; j < s.length(); j++) {
                matrix[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution422 solution422 = new Solution422();
        ArrayList<String> words = new ArrayList<>();
        words.add("abcd");
        words.add("bef");
        words.add("cfga");
        words.add("d");
        System.out.println(solution422.validWordSquare(words));
    }
}
