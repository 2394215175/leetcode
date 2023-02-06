package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-31
 **/
public class Solution2303 {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        int pre = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];
            if (income > upper) {
                ans += (upper - pre) * percent / 100.0;
                pre = upper;
            } else {
                ans += (income - pre) * percent / 100.0;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2303 solution2303 = new Solution2303();
        int[][] brackets = {{3, 50}, {7, 10}, {12, 25}};
        int income = 10;
        System.out.println(solution2303.calculateTax(brackets, income));
    }
}
