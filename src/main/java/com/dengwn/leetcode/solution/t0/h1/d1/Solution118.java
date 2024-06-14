package com.dengwn.leetcode.solution.t0.h1.d1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> zero = new ArrayList<>(1);
        zero.add(1);
        res.add(zero);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> arr = new ArrayList<>(i + 1);
            List<Integer> list = res.get(i - 1);
            int size = list.size();
            arr.add(list.get(0));
            for (int j = 1; j < size; j++) {
                arr.add(list.get(j) + list.get(j - 1));
            }
            arr.add(list.get(size - 1));
            res.add(arr);
        }

        return res;
    }


    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        System.out.println(solution118.generate(6));
    }
}
