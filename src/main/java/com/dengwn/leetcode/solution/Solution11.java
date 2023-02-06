package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-31
 **/
public class Solution11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left <= right) {
            int temp;
            if (height[left] < height[right]) {
                temp = (right - left) * height[left];
                left++;
            } else {
                temp = (right - left) * height[right];
                right--;
            }
            if (temp > ans) {
                ans = temp;
            }
        }
        return ans;
    }
}
