package com.dengwn.code.leetcode.solution.t2.h8.d4;

/**
 * @author dengwenning
 * @since 2024/7/25
 **/
public class Solution2844 {
    public int minimumOperations(String num) {
        num = "00" + num;
        int pre5 = num.lastIndexOf('5');
        int pre0 = num.lastIndexOf('0');
        int n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (pre5 != -1 && i < pre5 && (c == '2' || c == '7')) {
                return n - i - 2;
            }
            if (pre0 != -1 && i < pre0 && (c == '5' || c == '0')) {
                return n - i - 2;
            }
        }
        return n - 2;
    }


    public static void main(String[] args) {
        Solution2844 solution2844 = new Solution2844();
        System.out.println(solution2844.minimumOperations("2908305"));
    }
}
