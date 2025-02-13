package com.dengwn.code.leetcode.solution.t1.h7.d6;

/**
 * @author dengwn
 * @date: 2022-12-20
 */
public class Solution1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }
        int left = 0;
        int right = mx;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public boolean check(int[] nums, int max, int target) {
        int ans = 0;
        for (int num : nums) {
            ans += (num - 1) / target;
        }
        return ans <= max;
    }


    public static void main(String[] args) {
        Solution1760 solution1760 = new Solution1760();
        int[] nums = {1000000000,1000000000,1000000000};
        System.out.println(solution1760.minimumSize(nums, 1000000000));
    }
}
