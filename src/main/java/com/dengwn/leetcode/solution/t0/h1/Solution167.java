package com.dengwn.leetcode.solution.t0.h1;

import java.util.HashMap;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i + 1, map.get(diff)};
            }
        }
        return null;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
