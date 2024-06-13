package com.dengwn.leetcode.solution.t1.h6;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: dengwn
 * @date: 2022-12-05
 **/
public class Solution1687 {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] neg = new int[n + 1];
        long[] W = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (i > 1) {
                neg[i] = neg[i - 1] + (boxes[i - 2][0] != boxes[i - 1][0] ? 1 : 0);
            }
            W[i] = W[i - 1] + boxes[i - 1][1];
        }

        Deque<Integer> opt = new ArrayDeque<>();
        opt.offerLast(0);
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            while (i - opt.peekFirst() > maxBoxes || W[i] - W[opt.peekFirst()] > maxWeight) {
                opt.pollFirst();
            }

            f[i] = g[opt.peekFirst()] + neg[i] + 2;

            if (i != n) {
                g[i] = f[i] - neg[i + 1];
                while (!opt.isEmpty() && g[i] <= g[opt.peekLast()]) {
                    opt.pollLast();
                }
                opt.offerLast(i);
            }
        }

        return f[n];
    }

    public static void main(String[] args) {
        Solution1687 solution1687 = new Solution1687();
        int[][] boxes = {{1, 2}, {3, 3}, {3, 1}, {3, 1}, {2, 4}};
        System.out.println(solution1687.boxDelivering(boxes, 3, 3, 6));
    }
}
