package com.dengwn.leetcode.solution.t0.h5.d0;

import org.apache.tomcat.util.net.jsse.JSSEUtil;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author dengwenning
 * @since 2024/6/24
 **/
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int next = nums[(i + j + 1) % n];
                if (next > nums[i]) {
                    ans[i] = next;
                    break;
                }
            }
        }
        return ans;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int index = stack.pop();
                ans[index] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        Solution503 solution503 = new Solution503();
        System.out.println(Arrays.toString(solution503.nextGreaterElements1(nums)));
    }
}
