package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-02-28
 **/
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] nums = new int[26];
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();

        for (char c : chars2) {
            nums[c - 'a']++;
        }
        for (char c : chars1) {
            if(--nums[c-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
