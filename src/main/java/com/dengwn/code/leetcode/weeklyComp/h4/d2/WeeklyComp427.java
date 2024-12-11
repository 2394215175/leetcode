package com.dengwn.code.leetcode.weeklyComp.h4.d2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dengwenning
 * @since 2024/12/8
 **/
public class WeeklyComp427 {

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[i] = nums[(i + nums[i]) % n];
            } else if (nums[i] == 0) {
                result[i] = nums[i];
            } else {
                result[i] = nums[(i + 100 * n + nums[i]) % n];
            }
        }
        return result;
    }

    public int maxRectangleArea(int[][] points) {
        int n = points.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int[] a = points[i];
                        int[] b = points[j];
                        int[] c = points[k];
                        int[] d = points[l];
                        if (!check(a, b, c, d)) {
                            continue;
                        }
                        int maxX = Math.max(Math.max(a[0], b[0]), Math.max(c[0], d[0]));
                        int minX = Math.min(Math.min(a[0], b[0]), Math.min(c[0], d[0]));
                        int maxY = Math.max(Math.max(a[1], b[1]), Math.max(c[1], d[1]));
                        int minY = Math.min(Math.min(a[1], b[1]), Math.min(c[1], d[1]));
                        boolean isValid = true;
                        for (int m = 0; m < n; m++) {
                            if (m == i || m == j || m == k || m == l) {
                                continue;
                            }
                            if (points[m][0] >= minX && points[m][0] <= maxX && points[m][1] >= minY && points[m][1] <= maxY) {
                                isValid = false;
                            }
                        }
                        if (isValid) {
                            int area = (maxX - minX) * (maxY - minY);
                            ans = Math.max(ans, area);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public boolean check(int[] a, int[] b, int[] c, int[] d) {
        // 存储 x 和 y 坐标的集合
        Set<Integer> xCoords = new HashSet<>();
        Set<Integer> yCoords = new HashSet<>();
        xCoords.add(a[0]);
        xCoords.add(b[0]);
        xCoords.add(c[0]);
        xCoords.add(d[0]);
        yCoords.add(a[1]);
        yCoords.add(b[1]);
        yCoords.add(c[1]);
        yCoords.add(d[1]);
        return xCoords.size() == 2 && yCoords.size() == 2;
    }

    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] mn = new long[k];
        Arrays.fill(mn, Long.MAX_VALUE / 2);
        mn[k - 1] = 0;

        long ans = Long.MIN_VALUE / 2, sm = 0;
        // 枚举子数组右端点
        for (int i = 0; i < n; i++) {
            sm += nums[i];
            ans = Math.max(ans, sm - mn[i % k]);
            mn[i % k] = Math.min(mn[i % k], sm);
        }
        return ans;
    }


    public static void main(String[] args) {
        WeeklyComp427 weeklyComp427 = new WeeklyComp427();

//        int[] nums = {-10, -10};
//        System.out.println(Arrays.toString(weeklyComp427.constructTransformedArray(nums)));

//        int[][] points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {1, 2}, {3, 2}};
//        System.out.println(weeklyComp427.maxRectangleArea(points));

        int[] nums = {-1,-2,-3,-4,-5};
        int k = 4;
        System.out.println(weeklyComp427.maxSubarraySum(nums, k));

    }
}
