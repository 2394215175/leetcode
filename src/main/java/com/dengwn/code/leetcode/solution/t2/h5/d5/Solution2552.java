package com.dengwn.code.leetcode.solution.t2.h5.d5;

/**
 *
 * @author dengwenning
 * @since 2024/9/10
 **/
public class Solution2552 {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        long cnt4 = 0;
        int[] cnt3 = new int[n];
        for (int l = 2; l < n; l++) {
            int cnt2 = 0;
            for (int j = 0; j < l; j++) {
                if (nums[j] < nums[l]) {
                    // 3 < 4
                    cnt4 += cnt3[j];
                    // 把 j 当作 i，把 l 当作 k，现在 nums[i] < nums[k]，即 1 < 2
                    cnt2++;
                } else {
                    // 把 l 当作 k，现在 nums[j] > nums[k]，即 3 > 2
                    cnt3[j] += cnt2;
                }
            }
        }
        return cnt4;
    }

    public static void main(String[] args) {
        Solution2552 solution = new Solution2552();
        System.out.println(solution.countQuadruplets(new int[]{1, 3, 2, 4, 5}));
    }
}
