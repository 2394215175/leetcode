package com.dengwn.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2022-11-17
 **/
public class NSolution2097 {
    public int[][] validArrangement(int[][] pairs) {
        int[][] result = new int[pairs.length][2];
        dfs(pairs, 0, result, new ArrayList<>());

        return result;
    }

    public void dfs(int[][] pairs, int size, int[][] result, List<Integer> used) {
        if (size == pairs.length) {
            return;
        }
        List<Integer> list = used;
        for (int i = 0; i < pairs.length; i++) {

            if (size == 0) {
                result[0] = pairs[i];
                used.add(i);
                dfs(pairs, size + 1, result, used);
            } else if (result[size - 1][1] == pairs[i][0] && !list.contains(i)) {
                result[size] = pairs[i];
                used.add(i);
                dfs(pairs, size + 1, result, used);
            }
        }
    }
}
