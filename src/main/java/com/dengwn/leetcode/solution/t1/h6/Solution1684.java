package com.dengwn.leetcode.solution.t1.h6;

import java.util.HashSet;

/**
 * @author: dengwn
 * @date: 2022-12-01
 **/
public class Solution1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int size = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        for (String word : words) {
            boolean isFinish = true;
            for (int i = 0; i < word.length(); i++) {
                if(!set.contains(word.charAt(i))){
                    isFinish = false;
                    break;
                }
            }
            if(isFinish){
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","c","ab","ac","bc","abc"};
        Solution1684 solution1678 = new Solution1684();
        int i = solution1678.countConsistentStrings("abc", words);
        System.out.println(i);
    }
}
