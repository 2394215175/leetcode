package com.dengwn.code.leetcode.solution.t2.h9.d6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/7/30
 **/
public class Solution2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            if (mod(a, b, c, m) == target) {
                res.add(i);
            }
        }
        return res;
    }

    public int mod(int a, int b, int c, int m) {
        int mod1 = 1;
        while (b > 0) {
            mod1 *= a;
            mod1 %= 10;
            b--;
        }
        int mod2 = 1;
        while (c > 0) {
            mod2 *= mod1;
            mod2 %= m;
            c--;
        }
        return mod2;
    }
}
