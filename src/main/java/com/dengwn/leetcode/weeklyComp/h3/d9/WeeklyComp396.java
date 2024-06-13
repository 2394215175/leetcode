package com.dengwn.leetcode.weeklyComp.h3.d9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengwenning
 * @since 2024/5/5
 **/
public class WeeklyComp396 {

    List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3) {
            return false;
        }
        boolean hasA = false;
        boolean hasB = false;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (list.contains(c)) {
                    hasA = true;
                } else if (c > '9') {
                    hasB = true;
                }
            } else {
                return false;
            }
        }
        return hasA && hasB;
    }

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            map.merge(word.substring(i, i + k), 1, Integer::sum);
        }
        int sum = 0;
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            max = Math.max(max, entry.getValue());
        }
        return sum - max;
    }

    public int minAnagramLength(String s) {
        int[] tables = new int[26];
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            tables[s.charAt(i) - 'a']++;
            max = tables[s.charAt(i) - 'a'];
        }

        for (int i = 0; i < 26; i++) {
            if (tables[i] == 0) {
                continue;
            }
            max = gcd(max, tables[i]);
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += tables[i] / max;
        }

        return ans;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }


    int MOD = (int) 1e9 + 7;

    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n - 1];
        long ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (i == 0) {
                ans += (max - nums[i]) * (long) cost1;
            } else {
                if (cost2 > 2 * cost1) {
                    ans += (max - nums[i]) * (long) cost1;
                } else {
                    ans += (max - nums[i]) * (long) cost2;
                    nums[i - 1] += (max - nums[i]);
                }
            }

        }

        return (int) (ans % MOD);
    }


    public static void main(String[] args) {
        WeeklyComp396 weeklyComp396 = new WeeklyComp396();

//        System.out.println(weeklyComp396.isValid("AhI"));

//        System.out.println(weeklyComp396.minAnagramLength("cdef"));

        System.out.println(weeklyComp396.minCostToEqualizeArray(new int[]{1, 14, 14, 15}, 2, 1));
    }
}
