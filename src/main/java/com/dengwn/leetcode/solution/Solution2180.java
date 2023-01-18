package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution2180 {
    public static int countEven(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            int j = i;
            int sum = 0;
            while (j != 0) {
                sum += (j % 10);
                j /= 10;
            }
            ans += (sum % 2 == 0 ? 1 : 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = Solution2180.countEven(25);
        System.out.println(i);
    }
}
