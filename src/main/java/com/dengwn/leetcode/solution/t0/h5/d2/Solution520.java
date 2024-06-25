package com.dengwn.leetcode.solution.t0.h5.d2;

/**
 * @author dengwenning
 * @since 2024/6/23
 **/
public class Solution520 {
    public boolean detectCapitalUse(String word) {
        char[] array = word.toCharArray();
        int upper = 0;
        for (char c : array) {
            if (Character.isUpperCase(c)) {
                upper++;
            }
        }
        if (upper == 0 || upper == array.length){
            return true;
        }
        if (upper == 1 && Character.isUpperCase(array[0])) {
            return true;
        }
        return false;
    }
}
