package com.dengwn.leetcode.solution.t2.h4;

/**
 * @author: dengwn
 * @date: 2023-05-09
 **/
public class Solution2437 {
    public int countTime(String time) {
        int ans = 1;
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            ans *= 24;
        } else if (time.charAt(0) == '?') {
            if (time.charAt(1) >= '4') {
                ans *= 2;
            } else {
                ans *= 3;
            }
        } else if (time.charAt(1) == '?') {
            if (time.charAt(0) == '2') {
                ans *= 4;
            } else {
                ans *= 10;
            }
        }
        ans *= time.charAt(3) == '?' ? 6 : 1;
        ans *= time.charAt(4) == '?' ? 10 : 1;
        return ans;
    }

    public static void main(String[] args) {
        Solution2437 solution2437 = new Solution2437();
        System.out.println(solution2437.countTime("?4:00"));
    }
}
