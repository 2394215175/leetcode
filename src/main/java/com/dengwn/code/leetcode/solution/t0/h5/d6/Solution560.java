package com.dengwn.code.leetcode.solution.t0.h5.d6;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/12
 **/
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int preSum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>(n + 1);
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            preSum += nums[i - 1];
            ans += map.getOrDefault(preSum - k, 0);
            map.merge(preSum, 1, Integer::sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        int[] nums = {1};
        int k = 0;
        System.out.println(solution560.subarraySum(nums, k));
    }
}
