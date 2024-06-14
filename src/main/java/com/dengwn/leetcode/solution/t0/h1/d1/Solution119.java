package com.dengwn.leetcode.solution.t0.h1.d1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> zero = new ArrayList<>(1);
        zero.add(1);
        res.add(zero);
        for (int i = 1; i < rowIndex; i++) {
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

        return res.get(rowIndex - 1);
    }


    public List<Integer> getRow1(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= rowIndex; k++) {
            long cur = pre * (rowIndex - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }

}
