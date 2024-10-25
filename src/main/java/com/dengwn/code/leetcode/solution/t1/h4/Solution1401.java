package com.dengwn.code.leetcode.solution.t1.h4;

/**
 * @author: dengwn
 * @date: 2023-06-27
 **/
public class Solution1401 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int minx = xCenter >= x1 && xCenter <= x2 ? 0 : Math.min(Math.abs(x1 - xCenter), Math.abs(x2 - xCenter));
        int miny = yCenter >= y1 && yCenter <= y2 ? 0 : Math.min(Math.abs(y1 - yCenter), Math.abs(y2 - yCenter));
        return Math.sqrt(minx * minx + miny * miny) < radius;
    }
}
