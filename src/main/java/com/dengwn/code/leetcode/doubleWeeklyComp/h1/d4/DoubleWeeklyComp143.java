package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author dengwenning
 * @since 2024/11/11
 **/
public class DoubleWeeklyComp143 {

    public int smallestNumber(int n, int t) {
        while (true) {
            if (getNumber(n) % t == 0) {
                return n;
            }
            n++;
        }
    }

    public int getNumber(int n) {
        int ans = 1;
        while (n > 0) {
            ans *= n % 10;
            n /= 10;
        }
        return ans;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> cnt = new HashMap<>();
        TreeMap<Integer, Integer> diff = new TreeMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
            diff.putIfAbsent(num, 0);
            diff.merge(num - k, 1, Integer::sum);
            diff.merge(num + k + 1, -1, Integer::sum);
        }
        int ans = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            sum += entry.getValue();
            ans = Math.max(ans, Math.min(sum, cnt.getOrDefault(entry.getKey(), 0) + numOperations));
        }
        return ans;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp143 doubleWeeklyComp143 = new DoubleWeeklyComp143();

//        doubleWeeklyComp143.smallestNumber(15, 3);

        doubleWeeklyComp143.maxFrequency(new int[]{5, 11, 20, 20}, 5, 1);
    }
}
