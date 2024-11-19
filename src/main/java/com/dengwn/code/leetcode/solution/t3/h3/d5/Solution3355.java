package com.dengwn.code.leetcode.solution.t3.h3.d5;

/**
 *
 * @author dengwenning
 * @since 2024/11/18
 **/
public class Solution3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            cnt[l]++;
            cnt[r + 1]--;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cnt[i];
            if (sum < nums[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = {{1, 3}, {0, 2}};
        Solution3355 solution3355 = new Solution3355();
        System.out.println(solution3355.isZeroArray(nums, queries));
    }
}
