package com.dengwn.leetcode.solution.t1.h0;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-05-15
 **/
public class Solution1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int[] ans = new int[n];
        int[][] map = new int[10001][2];
        for (int i = 0; i < 10001; i++) {
            map[i][0] = i;
        }
        for (int barcode : barcodes) {
            map[barcode][1]++;
        }
        Arrays.sort(map, (o1, o2) -> o2[1] -o1[1]);
        int index = 0;
        for (int i = 0; i < 10001; i++) {
            int key = map[i][0];
            int val = map[i][1];
            if (val == 0){
                break;
            }
            for (int j = 0; j < val; j++) {
                ans[index] = key;
                index += 2;
                if (index >= n) {
                    index = 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1054 solution1054 = new Solution1054();
        int[] barcodes = {2, 1, 1};
        System.out.println(Arrays.toString(solution1054.rearrangeBarcodes(barcodes)));
    }
}
