package com.dengwn.code.leetcode.solution.t3.h3.d9;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution3399 {
    public int minLength(String s, int numOps) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(chars, mid, numOps)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public boolean check(char[] s, int m, int numOps) {
        int n = s.length;
        int cnt = 0;
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                cnt += (s[i] ^ i) & 1;
            }
            cnt = Math.min(cnt, n - cnt);
        } else {
            int k = 0;
            for (int i = 0; i < n; i++) {
                k++;
                if (i == n - 1 || s[i] != s[i + 1]) {
                    cnt += k / (m + 1);
                    k = 0;
                }
            }
        }
        return cnt <= numOps;
    }

    public static void main(String[] args) {
        Solution3399 solution3399 = new Solution3399();
        System.out.println(solution3399.minLength("0", 1));
    }
}
