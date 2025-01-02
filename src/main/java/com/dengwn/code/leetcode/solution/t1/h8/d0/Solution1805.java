package com.dengwn.code.leetcode.solution.t1.h8.d0;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution1805 {
    public int numDifferentIntegers(String word) {
        Set<String> nums = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c <= '9') {
                int j = i;
                while (j < word.length() && word.charAt(j) <= '9') {
                    j++;
                }
                while (i < j && word.charAt(i) == '0') {
                    i++;
                }
                nums.add(word.substring(i, j));
                i = j;
            }
        }

        return nums.size();
    }

    public static void main(String[] args) {
        Solution1805 solution1805 = new Solution1805();
        System.out.println(solution1805.numDifferentIntegers("0a0"));

    }
}
