package com.dengwn.leetcode.solution.t0.h8.d4;

/**
 * @author: dengwn
 * @date: 2022-11-15
 **/
public class Solution849 {
    public int maxDistToClosest(int[] seats) {
        int preIndex = -1;
        int maxLen = 0;
        int length = seats.length;
        for (int i = 0; i < length; i++) {
            if (seats[i] == 1) {
                if (preIndex == -1) {
                    maxLen = i;
                    preIndex = i;
                } else {
                    maxLen = Math.max(maxLen, (i - preIndex) / 2);
                    preIndex = i;
                }
            }

            if (i == length - 1) {
                maxLen = Math.max(maxLen, length - preIndex - 1);
            }
        }
        return maxLen;
    }

}
