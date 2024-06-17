package com.dengwn.leetcode.solution.t0.h5.d6;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-28
 **/
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] temp = Arrays.copyOf(chars, 26);
            int j = i;
            for (int k = 0; k < s1.length(); k++) {
                temp[s2.charAt(j) - 'a']--;
                j++;
            }
            for (int k = 0; k < temp.length; k++) {
                if (temp[k] != 0) {
                    break;
                }
                if (k == temp.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
        System.out.println(solution567.checkInclusion("adc", "dcda"));
    }
}
