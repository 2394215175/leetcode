package com.dengwn.code.leetcode.solution.t1.h8;

/**
 * @author: dengwn
 * @date: 2023-01-09
 **/
public class Solution1806 {
    public int reinitializePermutation(int n) {
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int times = flipsTimes(i, n);
            ans = lcm(ans, times);
        }
        return ans;
    }

    public int flipsTimes(int i, int n) {
        int temp = i;
        int ans = 0;
        while (ans == 0 || temp != i) {
            if (temp % 2 == 0) {
                temp /= 2;
            } else {
                temp = n / 2 + (temp - 1) / 2;
            }
            ans++;
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return b == 0 ? a : gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        Solution1806 solution1806 = new Solution1806();
        for (int n = 2; n <= 1000; n += 2) {
            for (int i = 0; i < n; i++) {
                System.out.print(solution1806.flipsTimes(i, n) + " ");
            }
            System.out.println();
        }
    }

}
