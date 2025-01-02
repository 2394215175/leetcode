package com.dengwn.code.leetcode.solution.t1.h8.d1;

/**
 * @author: dengwn
 * @date: 2023-01-16
 **/
public class Solution1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0;
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }
        boolean[] has = new boolean[mx + 1];
        for (int num : nums) {
            has[num] = true;
        }

        for (int i = 1; i <= mx; i++) {
            int g = 0;
            for (int j = i; j <= mx && g != i; j += i) {
                if (has[j]) {
                    // 如果 j 在 nums 中
                    // 更新最大公约数
                    g = gcd(g, j);
                }
            }
            if (g == i) {
                ++ans; // 找到一个答案
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution1819 solution1819 = new Solution1819();
        int[] nums = {5, 15, 40, 5, 6};
        System.out.println(solution1819.countDifferentSubsequenceGCDs(nums));
    }
}
