package com.dengwn.code.leetcode.solution.t2.h4.d4;

/**
 * @author: dengwn
 * @date: 2023-05-17
 **/
public class Solution2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event2[0].compareTo(event1[1]) > 0 || event1[0].compareTo(event2[1]) > 0);
    }
}
