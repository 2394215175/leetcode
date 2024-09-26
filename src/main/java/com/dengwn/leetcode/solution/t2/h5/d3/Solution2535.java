package com.dengwn.leetcode.solution.t2.h5.d3;

/**
 *
 * @author dengwenning
 * @since 2024/9/26
 **/
public class Solution2535 {
    public int differenceOfSum(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += diff(num);
        }
        return ans;
    }

    public int diff(int num) {
        int cnt = 0;
        int temp = num;
        while (temp > 0) {
            cnt += temp % 10;
            temp /= 10;
        }
        return num - cnt;
    }

    public static void main(String[] args) {
        Solution2535 solution = new Solution2535();
        System.out.println(solution.differenceOfSum(new int[]{1, 15, 6, 3}));
    }
}
