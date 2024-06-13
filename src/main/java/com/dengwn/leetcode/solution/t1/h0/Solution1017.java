package com.dengwn.leetcode.solution.t1.h0;

/**
 * @author: dengwn
 * @date: 2023-04-06
 **/
public class Solution1017 {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
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

    public String baseNeg21(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int k = 1;
        while (n != 0) {
            int sub = n % 2;
            sb.append(sub);
            n -= sub * k;
            k *= -1;
            n /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution1017 solution1017 = new Solution1017();
        System.out.println(solution1017.baseNeg21(6));
        System.out.println(-1 % -2);
    }
}
