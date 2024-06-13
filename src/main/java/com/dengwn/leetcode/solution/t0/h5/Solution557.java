package com.dengwn.leetcode.solution.t0.h5;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution557 {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(Solution557::reverseString)
                .collect(Collectors.joining(" "));
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - 1 - i];
            chars[n - 1 - i] = temp;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution557 solution557 = new Solution557();
        System.out.println(solution557.reverseWords("Let's take LeetCode contest"));
    }
}
