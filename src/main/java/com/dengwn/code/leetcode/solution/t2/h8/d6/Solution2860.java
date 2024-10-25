package com.dengwn.code.leetcode.solution.t2.h8.d6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/9/4
 **/
public class Solution2860 {

    public int countWays(List<Integer> nums) {
        // 加一个虚拟节点
        List<Integer> list = new ArrayList<>(nums);
        list.add(-1);
        list.sort(Integer::compare);
        int res = 0;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) < i && (i == n - 1 || list.get(i + 1) > i)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2860 solution = new Solution2860();
        List<Integer> list = Arrays.asList(1, 1);
        System.out.println(solution.countWays(list));
    }
}
