package com.dengwn.leetcode.solution.t1.h7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2022-11-23
 **/
public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            map.merge(calculateSize(i), 1, Integer::sum);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }

    public int calculateSize(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
