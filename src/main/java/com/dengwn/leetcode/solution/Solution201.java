package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-02-15
 **/
public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        int[] nums1 = new int[32];
        int[] nums2 = new int[32];
        for (int i = 31; i >= 0 && left > 0; i--) {
            nums1[i] = left % 2;
            left /= 2;
        }
        for (int i = 31; i >= 0 && right > 0; i--) {
            nums2[i] = right % 2;
            right /= 2;
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (nums1[i] == nums2[i]) {
                ans += nums1[i] * Math.pow(2, 31 - i);
            }else {
                break;
            }
        }
        return ans;
    }

    public int rangeBitwiseAnd1(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }


    public static void main(String[] args) {
        Solution201 solution201 = new Solution201();
        System.out.println(solution201.rangeBitwiseAnd1(1, 2147483647));
    }
}
