package com.dengwn.code.leetcode.solution.t2.h3.d1;

/**
 * @author: dengwn
 * @date: 2023-01-29
 **/
public class Solution2315 {
    public int countAsterisks(String s) {
        int ans = 0;
        boolean valid = false;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c == '|'){
                valid = !valid;
            }
            if(!valid && c == '*'){
                ans++;
            }
        }
        return ans;
    }
}
