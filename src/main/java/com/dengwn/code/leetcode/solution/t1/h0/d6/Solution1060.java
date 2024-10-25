package com.dengwn.code.leetcode.solution.t1.h0.d6;

/**
 * @author: dengwn
 * @date: 2023-03-31
 **/
public class Solution1060 {
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int pit = nums[right] - nums[left] - right + left;
        if (k > pit) {
            return nums[right] + k - pit;
        }
        while (left < right - 1) {
            int mid = left + right >> 1;
            int midPit = nums[mid] - nums[left] - mid + left;
            if (midPit >= k) {
                right = mid;
            } else {
                k -= midPit;
                left = mid;
            }
        }
        return nums[left] + k;
    }

    public static void main(String[] args) {
        int[] nums = {4, 7, 9, 10};
        int k = 3;
        Solution1060 solution1060 = new Solution1060();
        System.out.println(solution1060.missingElement(nums, k));
    }

}
