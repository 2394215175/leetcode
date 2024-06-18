package com.dengwn.leetcode.solution.t2.h4.d0;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-04-13
 **/
public class Solution2404 {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.merge(num, 1, Integer::sum);
            }
        }
        int size = map.size();
        if (size == 0) {
            return -1;
        }
        int[][] temp = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            temp[index++] = new int[]{entry.getKey(), entry.getValue()};
        }
        Arrays.sort(temp, (o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o1[0] - o2[0]);
        return temp[0][0];
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        Solution2404 solution2404 = new Solution2404();
        System.out.println(solution2404.mostFrequentEven(nums));
    }
}
