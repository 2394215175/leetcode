package com.dengwn.code.leetcode.weeklyComp.h3.d5;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: dengwn
 * @date: 2023-07-03
 **/
public class WeeklyComp352 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                ans = Math.max(ans, 1);
                // 起点
                int j = i + 1;
                while (j < n) {
                    if (nums[j] % 2 == nums[j - 1] % 2 || nums[j] > threshold) {
                        break;
                    }
                    j++;
                }
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    private int[] primeList = new int[150000];

    private void init(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int index = 0;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < isPrime.length; j++) {
                    isPrime[i * j] = false;
                }
                primeList[index++] = i;
            }
        }
        primeList = Arrays.copyOfRange(primeList, 0, index);
    }

    public List<List<Integer>> findPrimePairs(int n) {
        init(n);
        List<List<Integer>> res = new ArrayList<>();

        Set<Integer> set = Arrays.stream(primeList).boxed().collect(Collectors.toSet());
        for (int i = 0; i < primeList.length && primeList[i] <= n / 2; i++) {
            if (set.contains(n - primeList[i])) {
                res.add(Arrays.asList(primeList[i], n - primeList[i]));
            }
        }
        return res;
    }

    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int min = nums[j];
            int max = nums[j];
            while (j >= 0) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (max - min > 2) {
                    break;
                }
                j--;
            }
            ans += i - j;
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp352 weeklyComp352 = new WeeklyComp352();

//        int[] nums = {2, 3, 4, 5};
//        int threshold = 4;
//        System.out.println(weeklyComp352.longestAlternatingSubarray(nums, threshold));

//        System.out.println(weeklyComp352.findPrimePairs(1000000));

        int[] nums = {65, 66, 67, 66, 66, 65, 64, 65, 65, 64};
        System.out.println(weeklyComp352.continuousSubarrays(nums));
    }
}
