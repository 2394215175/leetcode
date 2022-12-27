package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dengwn
 * @date: 2022-12-25
 */
public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }

    public int[] sortedSquares1(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        int minIndex = 0;
        for (int i = 1; i < length; i++) {
            if (Math.abs(nums[minIndex]) > Math.abs(nums[i])) {
                minIndex = i;
            }
        }

        res[0] = nums[minIndex] * nums[minIndex];
        int left = minIndex - 1;
        int right = minIndex + 1;
        for (int i = 1; i < length; i++) {
            if (left < 0) {
                res[i] = nums[right] * nums[right];
                right++;
                continue;
            }
            if (right > length - 1) {
                res[i] = nums[left] * nums[left];
                left--;
                continue;
            }
            int leftVal = nums[left] * nums[left];
            int rightVal = nums[right] * nums[right];

            if (leftVal < rightVal) {
                res[i] = nums[left] * nums[left];
                left--;
            } else {
                res[i] = nums[right] * nums[right];
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution977 solution977 = new Solution977();
        int[] nums = {-4,-1,0,3,10};
        System.out.println(solution977.sortedSquares1(nums));
    }
}
