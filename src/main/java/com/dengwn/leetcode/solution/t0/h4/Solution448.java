package com.dengwn.leetcode.solution.t0.h4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwn
 * @date: 2022-12-14
 */
public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        boolean[] booleans = new boolean[length];
        for (int i = 0; i < length; i++) {
            booleans[nums[i]] = true;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (!booleans[i]) {
                res.add(i);
            }
        }

        return res;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution448 solution448 = new Solution448();
        System.out.println(solution448.findDisappearedNumbers1(nums));
    }

}
