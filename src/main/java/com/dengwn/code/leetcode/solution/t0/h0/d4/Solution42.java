package com.dengwn.code.leetcode.solution.t0.h0.d4;

/**
 *
 * @author dengwenning
 * @since 2024/12/12
 **/
public class Solution42 {
    public int trap(int[] height) {
        int left = 0;
        int leftMax = height[left];
        int right = height.length - 1;
        int rightMax = height[right];
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                left++;
                ans += Math.max(leftMax - height[left], 0);
            } else {
                right--;
                ans += Math.max(rightMax - height[right], 0);
            }
        }
        return ans;
    }

    public int trap1(int[] height) {
        int n = height.length;
        int[] preMax = new int[n]; // preMax[i] 表示从 height[0] 到 height[i] 的最大值
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        int[] sufMax = new int[n]; // sufMax[i] 表示从 height[i] 到 height[n-1] 的最大值
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i]; // 累加每个水桶能接多少水
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.trap1(height));
    }
}
