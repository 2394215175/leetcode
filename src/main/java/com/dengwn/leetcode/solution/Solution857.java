package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dengwenning
 * @since 2024/5/6
 **/
public class Solution857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] r = new double[n][2];
        for (int i = 0; i < n; i++) {
            r[i] = new double[]{wage[i] * 1.0 / quality[i], i};
        }
        Arrays.sort(r, (o1, o2) -> o1[0] - o2[0] > 0 ? 1 : -1);

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int sumQ = 0;
        for (int i = 0; i < k; i++) {
            int q = quality[(int) r[i][1]];
            queue.add(q);
            sumQ += q;
        }
        double ans = sumQ * r[k - 1][0];
        for (int i = k; i < n; i++) {
            int q = quality[(int) r[i][1]];
            if (q < queue.peek()) {
                sumQ -= queue.poll() - q;
                queue.offer(q);
            }
            ans = Math.min(ans, sumQ * r[i][0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution857 solution857 = new Solution857();
        int[] quality = {10, 20, 5}, wage = {70, 50, 30};
        int k = 2;
        System.out.println(solution857.mincostToHireWorkers(quality, wage, k));

    }

}
