package com.dengwn.code.leetcode.solution.t0.h6.d8;

/**
 *
 * @author dengwenning
 * @since 2025/2/5
 **/
public class Solution680 {
    public boolean validPalindrome(String s) {
        char[] array = s.toCharArray();
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
            } else {
                return validPalindrome(array, left + 1, right) || validPalindrome(array, left, right - 1);
            }
        }
        return true;
    }

    public boolean validPalindrome(char[] array, int low, int high) {
        while (low < high) {
            if (array[low] != array[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}