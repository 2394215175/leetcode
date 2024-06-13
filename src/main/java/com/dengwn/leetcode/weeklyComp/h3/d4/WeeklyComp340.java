package com.dengwn.leetcode.weeklyComp.h3.d4;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-04-09
 */
public class WeeklyComp340 {

    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        int n = nums.length;
        int m = nums[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j || i + j == n - 1) {
                    if (isPrime(nums[i][j])) {
                        ans = Math.max(ans, nums[i][j]);
                    }
                }
            }
        }
        return ans;
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        long[] ans = new long[n];
        for(List<Integer> indices : map.values()) {
            int m = indices.size();
            long ps = 0;
            for(int i = 0; i < m; i++) {
                int val = indices.get(i);
                ans[val] += (long)val * i - ps;
                ps += val;
            }
            ps = 0;
            for(int i = m - 1; i >= 0; i--) {
                int val = indices.get(i);
                ans[val] += ps - (long)val * (m - 1 - i);
                ps += val;
            }
        }
        return ans;
    }

    public int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int[] diff1 = new int[n / 2];
        int[] diff2 = new int[n / 2];
        Arrays.fill(diff1, Integer.MAX_VALUE);
        Arrays.fill(diff2, Integer.MAX_VALUE);
        for (int i = 0; i < n - 1; i += 2) {
            diff1[i / 2] = nums[i + 1] - nums[i];
        }
        if (2 * p == n) {
            Arrays.sort(diff1);
            return diff1[p - 1];
        }
        for (int i = 1; i < n - 1; i += 2) {
            diff2[i / 2] = nums[i + 1] - nums[i];
        }
        int[] ans = new int[n / 2];
        boolean pre = true;
        for (int i = 0; i < n / 2; i++) {
            if (pre) {
                if (diff1[i] <= diff2[i]) {
                    ans[i] = diff1[i];
                    pre = true;
                } else {
                    ans[i] = diff2[i];
                    pre = false;
                }
            } else {
                pre = true;
                ans[i] = diff2[i];
            }
        }
        Arrays.sort(ans);
        Arrays.sort(diff1);
        return Math.min(ans[p - 1], diff1[p - 1]);
    }

    public static void main(String[] args) {
        WeeklyComp340 weeklyComp340 = new WeeklyComp340();
//
//        int[][] nums = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
//        System.out.println(weeklyComp340.diagonalPrime(nums));

        int[] nums = {1, 3, 1, 1, 2, 1};
        System.out.println(Arrays.toString(weeklyComp340.distance(nums)));

//        int[] nums = {6,7,0,5,3,6};
//        int p = 3;
//        System.out.println(weeklyComp340.minimizeMax(nums, p));
    }
}
