package com.dengwn.leetcode.weeklyComp;

import com.sun.javafx.collections.MappingChange;

import javax.management.StringValueExp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dengwn
 * @date: 2023-02-12
 */
public class WeeklyComp332 {
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += concate(nums[i], nums[n - 1 - i]);
        }
        if (n % 2 == 1) {
            ans += nums[n / 2];
        }
        return ans;
    }

    public long concate(int num1, int num2) {
        int temp = num2;
        while (num2 != 0) {
            num1 = num1 * 10;
            num2 = num2 / 10;
        }
        return num1 + temp;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        int len = nums.length;
        Arrays.sort(nums);
        int[] newNums = new int[len + 2];
        newNums[0] = Integer.MIN_VALUE;
        for (int i = 1; i < len + 1; i++) {
            newNums[i] = nums[i - 1];
        }
        newNums[len + 1] = Integer.MAX_VALUE;
        long ans = 0;
        for (int i = 1; i < len + 2; i++) {
            int left = findLeft(newNums, lower - newNums[i]);
            int right = findRight(newNums, upper - newNums[i]);
            int n = left < i && i < right ? right - left - 2 : right - left - 1;
            ans += Math.max(n, 0);
        }
        return ans / 2;
    }

    public int findLeft(int[] nums, int lower) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] < lower && mid + 1 < nums.length && nums[mid + 1] >= lower) {
                return mid;
            }
            if (nums[mid] >= lower) {
                right = mid - 1;
            }
            if (nums[mid] < lower) {
                left = mid;
            }
        }
        return left;
    }

    public int findRight(int[] nums, int upper) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (mid - 1 > 0 && nums[mid - 1] <= upper && nums[mid] > upper) {
                return mid;
            }
            if (nums[mid] > upper) {
                right = mid;
            }
            if (nums[mid] <= upper) {
                left = mid + 1;
            }
        }
        return right;
    }

    static int[] def = new int[]{-1, -1};

    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = queries.length;
        int[][] res = new int[n][2];
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int val = 0;
            if (s.charAt(i) == '0') {
                if (!map.containsKey(0)) {
                    map.put(0, new int[]{i, i});
                }
                continue;
            }
            for (int j = i; j < s.length() && j < i + 31; j++) {
                val = (val << 1) + (s.charAt(j) - '0');
                if (!map.containsKey(val)) {
                    map.put(val, new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int[] ints = map.get(queries[i][0] ^ queries[i][1]);
            res[i] = ints == null ? def : ints;
        }
        return res;
    }

    public static void main(String[] args) {
        WeeklyComp332 weeklyComp332 = new WeeklyComp332();
        int[] nums1 = {5, 14, 13, 8, 12};
//        System.out.println(weeklyComp332.findTheArrayConcVal(nums1));

        int[] nums2 = {1,7,9,2,5};
        int lower = 11;
        int upper = 11;
        System.out.println(weeklyComp332.countFairPairs(nums2, lower, upper));

        String s = "010111010101000000001011001111111101010101010011011001010001110101111010000100101011011";
        int[][] queries = {{4, 11795793}};
//        System.out.println(Arrays.deepToString(weeklyComp332.substringXorQueries(s, queries)));
    }

}
