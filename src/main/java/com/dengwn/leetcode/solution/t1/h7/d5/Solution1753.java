package com.dengwn.leetcode.solution.t1.h7.d5;

/**
 * @author: dengwn
 * @date: 2022-12-21
 **/
public class Solution1753 {
    public int maximumScore(int a, int b, int c) {
        int ans = 0;
        while ((a > 0 && b > 0) || (a > 0 && c > 0) || (b > 0 && c > 0)) {
            ans++;
            if (a <= b && a <= c) {
                b--;
                c--;
            } else if (b <= a && b <= c) {
                a--;
                c--;
            } else {
                a--;
                b--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;
        System.out.println((a > 0 && b > 0) || (a > 0 && c > 0) || (b > 0 && c > 0));
    }
}
