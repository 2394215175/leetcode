package com.dengwn.leetcode.weeklyComp;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-02-19
 */
public class WeeklyComp333 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] num : nums1) {
            map.put(num[0], num[1]);
        }
        for (int[] num : nums2) {
            map.merge(num[0], num[1], Integer::sum);
        }

        int[][] ans = new int[map.size()][2];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[index++] = new int[]{entry.getKey(), entry.getValue()};
        }

        return ans;
    }

    int[] nums = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072};

    public int minOperations(int n) {
        int[] dp = new int[131073];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = 1;
        }

        int right = n;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < n && nums[i] >= n) {
                right = nums[i];
            }
        }
        for (int i = 3; i <= right; i++) {
            // 减法
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                } else {
                    break;
                }
            }
        }

        for (int i = right; i >= 3; i--) {
            // 加法
            for (int j = 0; j < nums.length; j++) {
                if (i + nums[j] <= right) {
                    dp[i] = Math.min(dp[i], dp[i + nums[j]] + 1);
                } else {
                    break;
                }
            }
        }

        for (int i = 3; i <= right; i++) {
            // 减法
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                } else {
                    break;
                }
            }
        }

        return dp[n];
    }

    int[] num = {4, 8, 12, 16, 20, 24, 28, 9, 18, 27, 25};

    public int squareFreeSubsets(int[] nums) {
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(8);
        set.add(12);
        set.add(16);
        set.add(20);
        set.add(24);
        set.add(28);
        set.add(9);
        set.add(18);
        set.add(27);
        set.add(25);


        int[] size = new int[31];
        for (int num : nums) {
            if (!set.contains(num)) {
                size[num]++;
            }
        }

        for (int i = 1; i < 31; i++) {
            for (int j = i + 1; j < 31; j++) {
                if (gcd(i, j) == 1) {
                    ans += (long) size[i] * size[j];
                    ans /= 1000000007;
                }
            }
        }
        return (int) ans;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        return b == 0 ? a : gcd(b, a % b);
    }


    public static void main(String[] args) {
        WeeklyComp333 weeklyComp333 = new WeeklyComp333();
//        int[][] nums1 = {{2, 3}, {1, 2}, {4, 5}};
//        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
//        System.out.println(Arrays.deepToString(weeklyComp333.mergeArrays(nums1, nums2)));
        System.out.println(weeklyComp333.minOperations(57410));

        for (int i = 0; i < 30; i++) {
            System.out.print((int) Math.pow(2, i) + ",");
        }

    }
}
