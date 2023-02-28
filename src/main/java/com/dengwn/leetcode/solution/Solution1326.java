package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: dengwn
 * @date: 2023-02-21
 **/
public class Solution1326 {
    public int minTaps(int n, int[] ranges) {
        int[][] bord = new int[ranges.length][2];
        for (int i = 0; i < ranges.length; i++) {
            bord[i] = new int[]{Math.max(0, i - ranges[i]), i + ranges[i]};
        }
        Arrays.sort(bord, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return -1;
            }
        });

        int ans = 0;
        int right = 0;

        for (int i = 0; i < bord.length && right < n; ) {
            int index = i;
            int tempRight = right;
            while (index < bord.length && bord[index][0] <= right) {
                tempRight = Math.max(tempRight, bord[index][1]);
                index++;
            }
            if (i == index) {
                return -1;
            }
            i = index;
            right = tempRight;
            ans++;
        }

        return ans;
    }

    public int minTaps1(int n, int[] ranges) {
        int[] rightMost = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            int r = ranges[i];
            // 这样写可以在 i>r 时少写一个 max
            // 凭借这个优化，恭喜你超越了 100% 的用户
            // 说「超越」是因为原来的最快是 2ms，现在优化后是 1ms
            if (i > r) {
                rightMost[i - r] = i + r; // 对于 i-r 来说，i+r 必然是它目前的最大值
            } else {
                rightMost[0] = Math.max(rightMost[0], i + r);
            }
        }

        int ans = 0;
        int curRight = 0; // 已建造的桥的右端点
        int nextRight = 0; // 下一座桥的右端点的最大值
        for (int i = 0; i < n; ++i) { // 注意这里没有遍历到 n，因为它已经是终点了
            nextRight = Math.max(nextRight, rightMost[i]);
            if (i == curRight) { // 到达已建造的桥的右端点
                if (i == nextRight) {
                    return -1; // 无论怎么造桥，都无法从 i 到 i+1
                }
                curRight = nextRight; // 造一座桥
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1326 solution1326 = new Solution1326();
        int n = 5;
        int[] ranges = {3, 4, 1, 1, 0, 0};
        System.out.println(solution1326.minTaps1(n, ranges));
    }

}
