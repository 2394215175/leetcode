package com.dengwn.code.leetcode.solution.t2.h0.d0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2024-04-08
 **/
public class Solution2009 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int ans = n - 1;
        Set<Integer> set = new HashSet<>();
        while (right < n) {
            int start = nums[left];
            while (right < n && nums[right] <= start + n - 1) {
                set.add(nums[right]);
                right++;
            }
            ans = Math.min(ans, n - set.size());
            set.remove(nums[left]);
            left++;
        }
        return ans;
    }

    public int minOperations1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i]; // 原地去重
            }
        }

        int ans = 0;
        int left = 0;
        for (int i = 0; i < m; i++) {
            while (nums[left] < nums[i] - n + 1) { // nums[left] 不在窗口内
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return n - ans;
    }

    public static void main(String[] args) {
        Solution2009 solution2009 = new Solution2009();
        System.out.println(solution2009.minOperations(new int[]{4, 5, 9, 10, 8, 4}));

    }
}
