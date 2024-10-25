package com.dengwn.code.leetcode.solution.t0.h1.d2;

/**
 * @author: dengwn
 * @date: 2023-04-25
 **/
public class Solution125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            }
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 32));
            }
            if (c >= '0' && c <= '9'){
                sb.append(c);
            }
        }
        char[] array = sb.toString().toCharArray();
        int m = array.length;
        for (int i = 0; i < m / 2; i++) {
            if (array[i] != array[m - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome1(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        StringBuffer reverse = new StringBuffer(sb).reverse();
        return sb.toString().equals(reverse.toString());
    }

    public static void main(String[] args) {
        Solution125 solution125 = new Solution125();
        System.out.println(solution125.isPalindrome("0P"));
    }
}
