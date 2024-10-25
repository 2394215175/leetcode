package com.dengwn.code.leetcode.solution.t0.h6.d9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/7/30
 **/
public class Solution699 {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        List<Integer> heights = new ArrayList<>();
        int n = positions.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int left = positions[i][0];
            int height = positions[i][1];
            int right = height + left;
            int low = 0;
            for (int j = i - 1; j >= 0; j--) {
                int l = positions[j][0];
                int r = positions[j][1] + l;
                if (l < right && r > left) {
                    low = Math.max(low, heights.get(j));
                }
            }
            heights.add(low + height);
            max = Math.max(max, low + height);
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] positions = {{50, 47}, {95, 48}, {88, 77}, {84, 3}, {53, 87}, {98, 79}, {88, 28}, {13, 22}, {53, 73}, {85, 55}};
        Solution699 solution699 = new Solution699();
        List<Integer> res = solution699.fallingSquares(positions);
        System.out.println(res);
    }
}
