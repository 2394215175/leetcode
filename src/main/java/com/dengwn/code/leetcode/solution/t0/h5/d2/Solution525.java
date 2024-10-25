package com.dengwn.code.leetcode.solution.t0.h5.d2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2022-11-15
 **/
public class Solution525 {
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0;
        for (int curIndex = 0; curIndex < length; curIndex++) {
            counter = nums[curIndex] == 0 ? counter - 1 : counter + 1;

            Integer preIndex = map.get(counter);
            if (preIndex != null) {
                maxLength = Math.max(maxLength, curIndex - preIndex);
            } else {
                map.put(counter, curIndex);
            }
        }

        return maxLength;
    }
}
