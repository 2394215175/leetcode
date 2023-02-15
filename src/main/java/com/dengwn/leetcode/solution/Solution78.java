package com.dengwn.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-02-08
 **/
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0){
                    result.add(nums[j]);
                }
            }
            ans.add(result);
        }
        return ans;
    }
    
}
