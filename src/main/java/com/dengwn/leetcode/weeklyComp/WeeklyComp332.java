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
        int ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> nums1 : map.entrySet()) {
            for (Map.Entry<Integer, Integer> nums2 : map.entrySet()) {
                Integer nums1Key = nums1.getKey();
                Integer nums2Key = nums2.getKey();
                int sum = nums1Key + nums2Key;
                if (lower <= sum && sum <= upper) {
                    if (nums1Key.equals(nums2Key)) {
                        ans += nums1.getValue() * (nums2.getValue() - 1);
                    } else {
                        ans += nums1.getValue() * nums2.getValue();
                    }
                }
            }
        }
        return ans / 2;
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
            for (int j = i; j < s.length(); j++) {
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
        System.out.println(weeklyComp332.findTheArrayConcVal(nums1));

        int[] nums2 = {0, 1, 7, 4, 4, 5};
        int lower = 3;
        int upper = 6;
        System.out.println(weeklyComp332.countFairPairs(nums2, lower, upper));

        String s = "010111010101000000001011001111111101010101010011011001010001110101111010000100101011011";
        int[][] queries = {{4,11795793}};
        System.out.println(Arrays.deepToString(weeklyComp332.substringXorQueries(s, queries)));
    }

//    "111010110"
//            [[4,2],[3,3],[6,4],[9,9],[10,28],[0,470],[5,83],[10,28],[8,15],[6,464],[0,3],[5,8],[7,7],[8,8],[6,208],[9,15],[2,2],[9,95]]
}
