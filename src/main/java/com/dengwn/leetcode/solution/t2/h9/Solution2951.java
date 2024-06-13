package com.dengwn.leetcode.solution.t2.h9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/5/28
 **/
public class Solution2951 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
