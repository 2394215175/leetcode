package com.dengwn.leetcode.weeklyComp.h3.d9;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/7
 **/
public class WeeklyComp390 {

    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';
                cnt[index]++;
                if (cnt[index] == 3) {
                    max = Math.max(max, j - i);
                    break;
                }
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    public int minOperations(int k) {
        if (k == 1) {
            return 0;
        }
        int ans = k;
        for (int i = 1; i < k; i++) {
            // 加i次
            ans = Math.min((k + i) / (i + 1) - 1 + i, ans);
        }
        return ans;
    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] ans = new long[n];

        // key: nums[i]; value: 频率
        HashMap<Integer, Long> cnt = new HashMap<>();
        // key: 频率; value: nums[i]集合
        TreeMap<Long, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            // 之前出现的频率
            Long pre = cnt.get(nums[i]);
            if (pre != null && map.get(pre) != null) {
                map.get(pre).remove(nums[i]);
                if (map.get(pre).isEmpty()) {
                    map.remove(pre);
                }
            }
            long f = cnt.merge(nums[i], (long) freq[i], Long::sum);
            if (f > 0) {
                map.computeIfAbsent(f, k -> new TreeSet<>()).add(nums[i]);
            }

            ans[i] = map.isEmpty() ? 0 : map.lastKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp390 weeklyComp390 = new WeeklyComp390();

//        System.out.println(weeklyComp390.maximumLengthSubstring("bcbbbcba"));

//        System.out.println(weeklyComp390.minOperations(11));

        int[] nums = {3, 3, 4, 3, 10};
        int[] freq = {4, -4, 3, 1, 2};

        System.out.println(Arrays.toString(weeklyComp390.mostFrequentIDs(nums, freq)));


    }


}
