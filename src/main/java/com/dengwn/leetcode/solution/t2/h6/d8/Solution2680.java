package com.dengwn.leetcode.solution.t2.h6.d8;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-05-15
 **/
public class Solution2680 {
    public long maximumOr(int[] nums, int k) {
        long ans = 0;
        int[] cnt = new int[47];
        for (int value : nums) {
            int num = value;
            int index = 0;
            while (num > 0) {
                cnt[index++] += num % 2;
                num /= 2;
            }
        }

        for (int value : nums) {
            int[] ints = Arrays.copyOf(cnt, 47);
            int num = value;
            int index = 0;
            while (num > 0) {
                ints[index + k] += num % 2;
                ints[index++] -= num % 2;
                num /= 2;
            }

            long temp = 0;
            for (int j = 46; j >= 0; j--) {
                temp <<= 1;
                temp += ints[j] == 0 ? 0 : 1;
            }
            ans = Math.max(temp, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {12, 9};
        int k = 1;
        Solution2680 solution2680 = new Solution2680();
        System.out.println(solution2680.maximumOr(nums, k));
    }
}
