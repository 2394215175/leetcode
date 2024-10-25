package com.dengwn.code.leetcode.solution.t0.h7;

/**
 * @author: dengwn
 * @date: 2023-02-03
 **/
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int product = 1;
            int j = i;
            while (j < n) {
                product *= nums[j];
                j++;
                if (product >= k) {
                    j--;
                    break;
                }
            }
            ans += j - i;
        }
        return ans;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution713 solution713 = new Solution713();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(solution713.numSubarrayProductLessThanK1(nums, k));
    }
}
