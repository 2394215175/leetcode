package com.dengwn.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1,Integer::sum);
        }

        int ans = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max){
                max = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(solution169.majorityElement(nums));
    }
}
