package com.dengwn.code.leetcode.solution.t0.h0.d5;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] nums = {-1, -2};
        System.out.println(solution53.maxSubArray1(nums));
    }

    public int maxSubArray1(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

}
class Status {
    public int lSum, rSum, mSum, iSum;

    public Status(int lSum, int rSum, int mSum, int iSum) {
        this.lSum = lSum;
        this.rSum = rSum;
        this.mSum = mSum;
        this.iSum = iSum;
    }
}


