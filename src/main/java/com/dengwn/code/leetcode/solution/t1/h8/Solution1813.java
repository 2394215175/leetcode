package com.dengwn.code.leetcode.solution.t1.h8;

/**
 * @author: dengwn
 * @date: 2023-01-16
 **/
public class Solution1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        if (arr1.length < arr2.length) {
            String[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int maxLen = arr1.length;
        int minLen = arr2.length;
        int left = 0;
        while (left < minLen && arr1[left].equals(arr2[left])) {
            left++;
        }
        int right = 0;

        while (right < minLen && arr1[maxLen - right - 1].equals(arr2[minLen - right - 1])) {
            right++;
        }
        return left + right >= minLen;
    }

    public static void main(String[] args) {
        Solution1813 solution1813 = new Solution1813();
        System.out.println(solution1813.areSentencesSimilar("c h p Ny", "c BDQ r h p Ny"));
    }
}
