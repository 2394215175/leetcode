package com.dengwn.code.leetcode.solution.t2.h0.d2;

/**
 * @author: dengwn
 * @date: 2022-12-27
 **/
public class Solution2027 {
    public int minimumMoves(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == 'X') {
                i += 3;
                ans++;
            } else {
                i++;
            }
        }
        return ans;
    }
}
