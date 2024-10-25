package com.dengwn.code.leetcode.weeklyComp.h3.d9;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/4/28
 **/
public class WeeklyComp395 {

    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // i,j 是要被删除的
                int index = 0;
                int diff = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    while (index == i || index == j){
                        index++;
                    }
                    if (k == 0) {
                        // 初始化
                        diff = nums2[k] - nums1[index];
                    }
                    if (diff != nums2[k] - nums1[index]){
                        break;
                    }
                    index++;
                    if (k == m - 1){
                        ans = Math.min(ans, diff);
                    }
                }
            }
        }
        return ans;
    }

    public long minEnd(int n, int x) {
        if (n == 1) {
            return x;
        }
        String sn = Integer.toBinaryString(n - 1);
        String sx = Integer.toBinaryString(x);
        while (sx.length() < 64) {
            sx = "0" + sx;
        }
        StringBuilder sb = new StringBuilder();
        int index = sn.length() - 1;
        for (int i = 63; i >= 0; i--) {
            if (sx.charAt(i) == '0' && index >= 0) {
                sb.append(sn.charAt(index));
                index--;
            } else {
                sb.append(sx.charAt(i));
            }
        }

        return Long.parseLong(sb.reverse().toString(), 2);
    }

    public static void main(String[] args) {
        WeeklyComp395 weeklyComp395 = new WeeklyComp395();

        int[] nums1 = {4, 6, 3, 1, 4, 2, 10, 9, 5};
        int[] nums2 = {5, 10, 3, 2, 6, 1, 9};

        System.out.println(weeklyComp395.minimumAddedInteger(nums1, nums2));
//        System.out.println(weeklyComp395.minEnd(3, 1));

    }
}
