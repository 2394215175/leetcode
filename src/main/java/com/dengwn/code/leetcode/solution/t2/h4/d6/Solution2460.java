package com.dengwn.code.leetcode.solution.t2.h4.d6;

/**
 * @author: dengwn
 * @date: 2023-06-05
 **/
public class Solution2460 {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < n; i++) {
            nums[i] = 0;
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution2460 solution2460 = new Solution2460();
//        int[] nums = {1, 2, 2, 1, 1, 0};
//        System.out.println(Arrays.toString(solution2460.applyOperations(nums)));

    }
}
