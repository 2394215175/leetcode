package com.dengwn.leetcode.solution.t2.h4.d2;

/**
 * @author: dengwn
 * @date: 2023-05-04
 **/
public class Solution2423 {
    public boolean equalFrequency(String word) {
        int[] dic = new int[26];
        char[] chars = word.toCharArray();
        for (char c : chars) {
            dic[c - 'a']++;
        }
        for (char c : chars) {
            dic[c - 'a']--;
            int cur = 0;
            boolean isTrue = true;
            for (int i = 0; i < 26; i++) {
                if (dic[i] == 0){
                    continue;
                }
                if (cur == 0){
                    cur = dic[i];
                }
                if (dic[i] != cur) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue){
                return true;
            }
            dic[c - 'a']++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2423 solution2423 = new Solution2423();
        System.out.println(solution2423.equalFrequency("aazz"));
    }
}
