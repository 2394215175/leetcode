package com.dengwn.code.leetcode.solution.t1.h7.d6;

/**
 * @author dengwn
 * @date: 2022-12-17
 */
public class Solution1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length && i < groups.length;) {
            if (check(groups[i], nums, k)) {
                k += groups[i].length;
                i++;
            } else {
                k++;
            }
        }
        return i == groups.length;
    }

    public boolean check(int[] group,int[] nums, int k) {
        if (k + group.length > nums.length) {
            return false;
        }
        for (int j = 0; j < group.length; j++) {
            if (group[j] != nums[k + j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] groups = {{1,2,3},{3,4}};
        int[] nums = {7,7,1,2,3,4,7,7};
        Solution1764 solution1764 = new Solution1764();
        System.out.println(solution1764.canChoose(groups, nums));
    }

}
