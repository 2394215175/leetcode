package com.dengwn.code.leetcode.solution.t0.h4;

/**
 * @author: dengwn
 * @date: 2022-11-15
 **/
public class Solution461 {
    public int hammingDistance(int x, int y) {
        int res = 0;

        for (int i = 31; i >= 0; i--) {
            int xBit = x >> i;
            int yBit = y >> i;

            if (xBit != yBit) {
                res++;
            }
            if (xBit == 1) {
                x = x - (int) Math.pow(2, i);
            }
            if (yBit == 1) {
                y = y - (int) Math.pow(2, i);
            }
        }

        return res;
    }

    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance2(int x, int y) {
        int s = x ^ y;
        int ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }
}
