package com.dengwn.leetcode.solution.t2.h3;

/**
 * @author: dengwn
 * @date: 2023-02-16
 **/
public class Solution2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] dictionary = new int[101];
        for (int num : nums) {
            dictionary[num]++;
        }
        int first = 0;
        int second = 0;
        for (int j : dictionary) {
            first += j / 2;
            second += j % 2;
        }
        return new int[]{first, second};
    }
}
