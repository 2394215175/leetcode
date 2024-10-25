package com.dengwn.code.leetcode.solution.t0.h2;

/**
 * @author: dengwn
 * @date: 2022-12-23
 **/
public class Solution278 {
    int bad = 1702766719;

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    boolean isBadVersion(int version) {
        return version >= bad;
    }

    public static void main(String[] args) {
        Solution278 solution278 = new Solution278();
        System.out.println(solution278.firstBadVersion(2126753390));
    }
}
