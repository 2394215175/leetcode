package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author dengwenning
 * @since 2024/5/24
 **/
public class Solution1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + n - i > k) {
                stack.pop();
            }
            if (stack.size() < k){
                stack.add(nums[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1673 solution1673 = new Solution1673();
        int[] nums = {3,5,2,6};
        int k = 2;
        System.out.println(Arrays.toString(solution1673.mostCompetitive(nums, k)));

    }
}
