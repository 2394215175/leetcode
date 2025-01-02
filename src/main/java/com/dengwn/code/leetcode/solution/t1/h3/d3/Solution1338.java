package com.dengwn.code.leetcode.solution.t1.h3.d3;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author dengwenning
 * @since 2024/12/15
 **/
public class Solution1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((o1, o2) -> o2 - o1);
        int res = 0;
        int sum = arr.length;
        for (Integer entry : list) {
            sum -= entry;
            res++;
            if (sum <= arr.length / 2) {
                return res;
            }
        }
        return res;
    }
}
