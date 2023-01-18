package com.dengwn.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-01-17
 **/
public class Solution1814 {
    static final int MOD = 1000000007;

    public int countNicePairs(int[] nums) {
        HashMap<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            int i = num;
            int newNum = 0;
            while (i > 0) {
                newNum *= 10;
                newNum += (i % 10);
                i /= 10;
            }
            map.merge(newNum - num, 1L, Long::sum);
        }

        long ans = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            Long value = entry.getValue();
            ans += value * (value - 1) / 2;
            ans %= MOD;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int[] nums = {13, 10, 35, 24, 76};
        Solution1814 solution1814 = new Solution1814();
        System.out.println(solution1814.countNicePairs(nums));
    }
}
