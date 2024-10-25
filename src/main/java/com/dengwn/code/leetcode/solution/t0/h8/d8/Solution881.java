package com.dengwn.code.leetcode.solution.t0.h8.d8;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/6/11
 **/
public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            count++;
        }
        return count;
    }
}
