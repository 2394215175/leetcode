package com.dengwn.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2022-12-08
 **/
public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }
            int pre = i - 1;
            if (nums[i] - nums[pre] != 1) {
                res.add(pre == index ? nums[index] + "" : nums[index] + "->" + nums[pre]);
                index = i;
            }
        }
        res.add(nums.length - 1 == index ? nums[index] + "" : nums[index] + "->" + nums[nums.length - 1]);
        return res;
    }

    public static void main(String[] args) {
        Solution228 solution228 = new Solution228();
        int[] nums = {-1};
        System.out.println(solution228.summaryRanges(nums));
    }
}
