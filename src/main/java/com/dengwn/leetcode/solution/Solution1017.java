package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-04-06
 **/
public class Solution1017 {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            if (n % -2 == 0) {
                sb.insert(0, "0");
            } else {
                n -= 1;
                sb.insert(0, "1");
            }
            n /= -2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1017 solution1017 = new Solution1017();
        System.out.println(solution1017.baseNeg2(6));
        System.out.println(-1 % -2);
    }
}
