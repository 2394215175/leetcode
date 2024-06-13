package com.dengwn.leetcode.solution.t0.h0.d1;

/**
 * @author: dengwn
 * @date: 2022-12-09
 **/
public class Solution13 {
    public int romanToInt(String s) {
        int ans = 0;
        int pre = 2000;
        for (int i = 0; i < s.length(); i++) {
            int integer = getValue(s.charAt(i));
            if (integer <= pre) {
                ans += integer;
                pre = integer;
            } else {
                ans = ans - 2 * pre + integer;
            }
        }
        return ans;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.romanToInt("MCMXCIV"));
    }
}
