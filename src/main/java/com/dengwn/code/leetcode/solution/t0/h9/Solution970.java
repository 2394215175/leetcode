package com.dengwn.code.leetcode.solution.t0.h9;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-05-04
 **/
public class Solution970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int value1 = 1;
        int value2 = 1;
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 0; i < 21; i++) {
            if (value1 <= bound && value1 > 0) {
                set1.add(value1);
            }
            if (value2 <= bound && value2 > 0) {
                set2.add(value2);
            }
            value1 *= x;
            value2 *= y;
        }
        Set<Integer> ans = new HashSet<>();
        for (int i = 2; i <= bound; i++) {
            for (Integer s1 : set1) {
                int s2 = i - s1;
                if (s2 < 0) {
                    break;
                }
                if (set2.contains(s2)) {
                    ans.add(i);
                }
            }
        }
        return new ArrayList<>(ans);
    }


    public static void main(String[] args) {
        Solution970 solution970 = new Solution970();
        System.out.println(solution970.powerfulIntegers(4, 48, 800000));
    }
}
