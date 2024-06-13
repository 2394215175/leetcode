package com.dengwn.leetcode.solution.t0.h2;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2024-03-23
 **/
public class Solution274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
