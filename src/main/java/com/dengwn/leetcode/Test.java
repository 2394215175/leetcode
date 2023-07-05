package com.dengwn.leetcode;


import java.util.ArrayList;

/**
 * @author: dengwn
 * @date: 2023-06-21
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(revers("abcd", 0));
    }

    public static String revers(String s, int i) {
        if (i == s.length()) {
            return "";
        }

        String ans = "";
        i++;
        ans += revers(s, i) + s.charAt(i - 1);
        return ans;
    }
}
