package com.dengwn.leetcode.weeklyComp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengwenning
 * @since 2024/5/26
 **/
public class WeeklyComp399 {

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                if (i % (j * k) == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public String compressedString(String word) {
        int n = word.length();
        StringBuilder sb = new StringBuilder();
        char c = word.charAt(0);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == c) {
                count++;
            }
            if (word.charAt(i) != c) {
                sb.append(count).append(c);
                count = 1;
                c = word.charAt(i);
            }
            if (count == 10) {
                sb.append(9).append(c);
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }

    /**
     * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
     * 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
     * 返回 优质数对 的总数。
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long numberOfPairs1(int[] nums1, int[] nums2, int k) {
        int n = 1000001;
        int[] map = new int[n];
        for (int num : nums1) {
            for (int j = 1; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    map[j]++;
                    if (num / j != j) {
                        map[num / j]++;
                    }
                }
            }
        }

        long ans = 0;
        for (int j : nums2) {
            int num = j * k;
            ans += num < n ? map[num] : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp399 weeklyComp399 = new WeeklyComp399();

//        System.out.println(weeklyComp399.compressedString("aaaaaaaaaaaaaabb"));

        int[] nums1 = {7, 17, 20, 20, 4};
        int[] nums2 = {1, 20, 21, 5, 5};
        int k = 4;
        System.out.println(weeklyComp399.numberOfPairs1(nums1, nums2, k));
    }

}
