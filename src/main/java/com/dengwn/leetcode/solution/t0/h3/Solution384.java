package com.dengwn.leetcode.solution.t0.h3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: dengwn
 * @date: 2023-02-16
 **/
public class Solution384 {

}

class Solution {
    int[] source;
    List<Integer> target;

    public Solution(int[] nums) {
        source = nums;
        target = Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    public int[] reset() {
        return source;
    }

    public int[] shuffle() {
        Collections.shuffle(target);
        return target.stream().mapToInt(Integer::valueOf).toArray();
    }
}
