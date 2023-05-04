package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-04-24
 **/
public class Solution1163 {
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 1;
        int k = 0;
        char ch1;
        char ch2;
        while(j + k < n){
            ch1 = s.charAt(i + k);
            ch2 = s.charAt(j + k);
            if(ch1 == ch2){
                k++;
            }else if(ch1 < ch2){
                i += k + 1;
                k = 0;
                if(i >= j){
                    j = i + 1;
                }
            }else{
                j += k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }

    public static void main(String[] args) {
        Solution1163 solution1163 = new Solution1163();
        System.out.println(solution1163.lastSubstring("cacacb"));
    }
}
