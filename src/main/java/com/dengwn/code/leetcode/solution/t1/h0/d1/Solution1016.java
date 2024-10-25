package com.dengwn.code.leetcode.solution.t1.h0.d1;

/**
 * @author: dengwn
 * @date: 2023-05-11
 **/
public class Solution1016 {
    public boolean queryString(String s, int n) {
        if (n > 2048){
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }
}
