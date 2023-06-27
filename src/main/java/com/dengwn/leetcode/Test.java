package com.dengwn.leetcode;


/**
 * @author: dengwn
 * @date: 2023-06-21
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final String a = "a";
        final String b = "b";
        String ab = "ab";
        String c = a + b;
        String d = "ab";
        System.out.println(ab == c);
        System.out.println(ab == d);
        System.out.println(ab.hashCode());
        System.out.println(c.hashCode());
    }
}
