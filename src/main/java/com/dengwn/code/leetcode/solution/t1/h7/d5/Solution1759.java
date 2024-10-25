package com.dengwn.code.leetcode.solution.t1.h7.d5;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution1759 {
    int MOD = 1000000007;

    public int countHomogenous(String s) {
        char pre = s.charAt(0);
        int size = 1;
        int ans = size;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == pre) {
                size++;
            } else {
                pre = cur;
                size = 1;
            }
            ans += size;
            ans %= MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Math.log(1000000000));
    }

}
