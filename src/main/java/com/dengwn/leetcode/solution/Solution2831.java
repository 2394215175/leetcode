package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/5/23
 **/
public class Solution2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = map.getOrDefault(nums.get(i), new ArrayList<>());
            list.add(i);
            map.put(nums.get(i), list);
        }

        int ans = 0;
        for (List<Integer> value : map.values()) {
            int n = value.size();
            int left = 0;
            int right = 0;
            while (right < n && left < n) {
                if (k >= value.get(right) - value.get(left) - (right - left)){
                    ans = Math.max(ans, right - left + 1);
                    right++;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2831 solution2831 = new Solution2831();
        List<Integer> list = Arrays.asList(1,1,2,2,1,1);
        System.out.println(solution2831.longestEqualSubarray(list, 2));
    }
}
