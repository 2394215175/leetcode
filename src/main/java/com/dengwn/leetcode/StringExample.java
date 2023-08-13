package com.dengwn.leetcode;

import java.util.HashSet;

/**
 * @author dengwn
 * @date: 2023-06-24
 */
public class StringExample {
    public static String addString(String s) {
        s = s + "bbb";
        return s;
    }

    public static StringBuilder addStringBuilder(StringBuilder sb) {
        return sb.append("bbb");
    }

    public static void main(String[] args) {
        // string做参数
        String s = "aaa";
        addString(s);
        System.out.println("String s: aaa -> " + s);

        // stringBuilder做参数
        StringBuilder sb = new StringBuilder("aaa");
        addStringBuilder(sb);
        System.out.println("StringBuilder sb: aaa -> " + sb.toString());

        HashSet<StringBuilder> hs = new HashSet<>();
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("aaabbb");
        hs.add(sb1);
        hs.add(sb2);
        //这时候HashSet里是{"aaa","aaabbb"}
        StringBuilder sb3 = sb1;
        sb3.append("bbb"); //这时候HashSet里是{"aaabbb","aaabbb"}
        System.out.println(hs);

    }
}
