package com.dengwn.code.leetcode.solution.t0.h9.d8;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-01-31
 **/
public class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int length1 = firstList.length;
        int length2 = secondList.length;
        int[][] ans = new int[2000][2];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < length1 && index2 < length2) {

            int a1 = firstList[index1][0];
            int a2 = firstList[index1][1];

            int b1 = secondList[index2][0];
            int b2 = secondList[index2][1];
            if (a1 > b2) {
                index2++;
            }
            if (a2 < b1) {
                index1++;
            }

            if (a1 <= b1 && b1 <= a2) {
                ans[index++] = new int[]{b1, a2};
                index1++;
            }

            if (b1 <= a1 && a1 <= b2) {
                ans[index++] = new int[]{a1, b2};
                index2++;
            }

            if (a1 >= b1 && a2 <= b2) {
                ans[index++] = new int[]{a1, a2};
                index1++;
            }

            if (b1 >= a1 && b2 <= a2) {
                ans[index++] = new int[]{b1, b2};
                index2++;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }

    public int[][] intervalIntersection1(int[][] A, int[][] B) {
        int[][] ans = new int[2000][2];
        int i = 0, j = 0;

        int index = 0;
        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) {
                ans[index++] = new int[]{lo, hi};

            }

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }

        }

        return Arrays.copyOfRange(ans, 0, index);
    }


    public static void main(String[] args) {
        Solution986 solution986 = new Solution986();
        int[][] firstList = {{3, 10}};
        int[][] secondList = {{5, 10}};
        System.out.println(solution986.intervalIntersection(firstList, secondList));

    }


}
