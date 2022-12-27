package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-12-27
 **/
public class Solution1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            product *= i;
            sum += i;
            n /= 10;
        }
        return product - sum;
    }
}
