package com.dengwn.leetcode.solution.t0.h1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
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

    public int majorityElement1(int[] nums) {
        int cnt = 0;
        int candidate = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            cnt += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(solution169.majorityElement(nums));
    }
}
