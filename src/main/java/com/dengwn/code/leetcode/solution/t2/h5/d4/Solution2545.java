package com.dengwn.code.leetcode.solution.t2.h5.d4;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/12/23
 **/
public class Solution2545 {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
        return score;
    }
}
