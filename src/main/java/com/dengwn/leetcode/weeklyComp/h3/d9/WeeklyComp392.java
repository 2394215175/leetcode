package com.dengwn.leetcode.weeklyComp.h3.d9;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2024-04-07
 **/
public class WeeklyComp392 {

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int up = 1;
        int down = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up++;
                down = 1;
            } else if (nums[i] < nums[i - 1]) {
                down++;
                up = 1;
            } else {
                up = 1;
                down = 1;
            }
            res = Math.max(res, Math.max(up, down));
        }
        return res;
    }

    public String getSmallestString(String s, int k) {
        if (k == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int index = 0;
        while (k != 0 && index < n) {
            int diff = chars[index] - 'a';
            if (diff == 0) {
                index++;
                continue;
            }
            int mind = Math.min(26 - diff, diff);
            if (k >= mind) {
                chars[index] = 'a';
                k -= mind;
            } else {
                chars[index] = (char) (chars[index] - k);
                k = 0;
            }
            index++;
        }
        return new String(chars);
    }

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = nums[n / 2];
        long res = 0;
        if (mid == k) {
            return res;
        } else if (mid < k) {
            for (int i = n / 2; i < n; i++) {
                res += Math.max(k - nums[i], 0);
            }
        } else {
            for (int i = n / 2; i >= 0; i--) {
                res += Math.max(nums[i] - k, 0);
            }
        }
        return res;
    }

    int fa[];

    public int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }

        return fa[x];
    }

    public void merge(int i, int j) {
        fa[find(i)] = find(j);
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int[] edge : edges) {
            merge(edge[0], edge[1]);
        }

        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        for (int[] edge : edges) {
            arr[find(edge[0])] &= edge[2];
        }

        int[] res = new int[query.length];
        int index = 0;
        for (int[] q : query) {
            if (q[0] == q[1]) {
                res[index++] = 0;
            } else if (find(q[0]) != find(q[1])) {
                res[index++] = -1;
            } else {
                res[index++] = arr[find(q[0])];
            }
        }
        return res;
    }

    public int[] minimumCost1(int n, int[][] edges, int[][] query) {
        int[] fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        int[] and_ = new int[n];
        Arrays.fill(and_, -1);

        for (int[] e : edges) {
            int x = find(e[0], fa);
            int y = find(e[1], fa);
            and_[y] &= e[2];
            if (x != y) {
                and_[y] &= and_[x];
                fa[x] = y;
            }
        }

        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0], t = query[i][1];
            ans[i] = s == t ? 0 : find(s, fa) != find(t, fa) ? -1 : and_[find(s, fa)];
        }
        return ans;
    }

    private int find(int x, int[] fa) {
        if (fa[x] != x) {
            fa[x] = find(fa[x], fa);
        }
        return fa[x];
    }


    public static void main(String[] args) {
        WeeklyComp392 weeklyComp392 = new WeeklyComp392();

//        System.out.println(weeklyComp392.longestMonotonicSubarray(new int[]{1, 10, 10}));

//        System.out.println(weeklyComp392.getSmallestString("xaxcd", 4));

//        System.out.println(weeklyComp392.minOperationsToMakeMedianK(new int[]{1,2,3,4,5,6}, 4));

        System.out.println(Arrays.toString(weeklyComp392.minimumCost1(9, new int[][]{{0, 4, 7}, {3, 5, 1}, {1, 3, 5}, {1, 5, 1}}, new int[][]{{0, 4}, {1, 5}, {3, 0}, {3, 3}, {3, 2}, {2, 0}, {7, 7}, {7, 0}})));

    }
}
