package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-06-27
 **/
public class Solution1186 {
    public int maximumSum(int[] arr) {
        int dp0 = arr[0], dp1 = 0, res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = (Math.max(dp0, 0)) + arr[i];
            if (dp0 > res){
                res = dp0;
            }
            if (dp1 > res){
                res = dp1;
            }
        }
        return res;
    }
}
