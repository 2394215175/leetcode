package com.dengwn.leetcode.solution.t1.h3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution1356 {

    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, Integer.bitCount(i));
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (map.get(arr[j]) > map.get(arr[j + 1]) || (map.get(arr[j]).equals(map.get(arr[j + 1])) && arr[j] > arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution1356 solution1356 = new Solution1356();
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        System.out.println(solution1356.sortByBits(arr));
    }
}
