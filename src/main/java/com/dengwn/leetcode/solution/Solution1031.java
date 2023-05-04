package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-04-26
 **/
public class Solution1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int n1 = n - firstLen + 1;
        int n2 = n - secondLen + 1;
        int[] first = new int[n1];
        int[] second = new int[n2];
        for (int i = 0; i < firstLen; i++) {
            first[0] += nums[i];
        }
        for (int i = 1; i < n1; i++) {
            first[i] = first[i - 1] - nums[i - 1] + nums[i + firstLen - 1];
        }

        for (int i = 0; i < secondLen; i++) {
            second[0] += nums[i];
        }
        for (int i = 1; i < n2; i++) {
            second[i] = second[i - 1] - nums[i - 1] + nums[i + secondLen - 1];
        }

        int max = 0;
        for (int i = 0; i < n1; i++) {
            // 向左
            int left = i + firstLen;
            while (left < n2) {
                max = Math.max(max, first[i] + second[left]);
                left++;
            }

            // 向右
            int right = i - secondLen;
            while (right >= 0) {
                max = Math.max(max, first[i] + second[right]);
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution1031 solution1031 = new Solution1031();
        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen = 1;
        int secondLen = 2;
        System.out.println(solution1031.maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }
}
