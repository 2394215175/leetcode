package com.dengwn.code.leetcode.solution.t1.h4;

/**
 * @author: dengwn
 * @date: 2022-12-28
 **/
public class Solution1404 {
    public int numSteps(String s) {
        char[] chars = new char[s.length() + 1];
        int ans = 0;
        chars[0] = '0';
        for (int i = 1; i < chars.length; i++) {
            char c = s.charAt(i - 1);
            chars[i] = c;
        }
        for (int i = chars.length - 1; i >= 1; ) {
            if(i == 1 && chars[i] == '1' && chars[0] == '0'){
                break;
            }
            if (chars[i] == '1') {
                chars[i] = '0';
                chars[i - 1] += 1;
                ans++;
            } else if (chars[i] == '0') {
                i--;
                ans++;
            }else {
                chars[i] = '0';
                chars[i - 1] += 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution1404 solution1404 = new Solution1404();
        System.out.println(solution1404.numSteps("110"));
    }
}
