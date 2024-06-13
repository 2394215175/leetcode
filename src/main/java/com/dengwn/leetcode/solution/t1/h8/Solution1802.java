package com.dengwn.leetcode.solution.t1.h8;

/**
 * @author: dengwn
 * @date: 2023-01-04
 **/
public class Solution1802 {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (valid(mid, n, index, maxSum)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public boolean valid(int mid, int n, int index, int maxSum) {
        int left = index + 1;
        int right = n - index;
        return cal(mid, left) + cal(mid, right) - mid <= maxSum;
    }

    public long cal(int max, int len) {
        if (max > len) {
            return (2L * max - len + 1) * len / 2;
        } else {
            return (long) max * (max - 1) / 2 + len;
        }
    }


    public static void main(String[] args) {
        Solution1802 solution1802 = new Solution1802();
        System.out.println(solution1802.maxValue(3, 0, 815094800));
    }

}
