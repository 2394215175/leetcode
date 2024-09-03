package com.dengwn.leetcode.solution.t0.h5.d5;

/**
 * @author dengwenning
 * @since 2024/8/19
 **/
public class Solution551 {
    public boolean checkRecord(String s) {
        char[] array = s.toCharArray();
        int cntA = 0;
        int preL = 0;
        for (char c : array) {
            if (c == 'A') {
                cntA++;
                if (cntA == 2) {
                    return false;
                }
                preL = 0;
            } else if (c == 'L') {
                preL++;
                if (preL == 3) {
                    return false;
                }
            } else if (c == 'P') {
                preL = 0;
            }
        }
        return true;
    }
}
