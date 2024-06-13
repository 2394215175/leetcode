package com.dengwn.leetcode.solution.t2.h3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: dengwn
 * @date: 2023-02-28
 **/
public class Solution2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int[] ints : items1) {
            map.put(ints[0],ints[1]);
        }

        for (int[] ints : items2) {
            map.merge(ints[0],ints[1],Integer::sum);
        }
        List<List<Integer>> ans = map.entrySet().stream().map(e -> Arrays.asList(e.getKey(), e.getValue())).collect(Collectors.toList());
        Collections.sort(ans, Comparator.comparingInt(o -> o.get(0)));
        return ans;
    }
}
