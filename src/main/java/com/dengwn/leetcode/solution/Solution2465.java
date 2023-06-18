package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dengwn
 * @date: 2023-06-04
 */
public class Solution2465 {
    public int distinctAverages(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] cnt = new int[201];
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            if (++cnt[nums[i] + nums[n - i - 1]] == 1){
                ans++;
            }
        }
        return ans;
    }
}
