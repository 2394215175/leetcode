package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d3;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/5/25
 **/
public class DoubleWeeklyComp131 {

    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        int[] tmp = new int[51];
        for (int num : nums) {
            tmp[num]++;
        }
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 2) {
                ans ^= i;
            }
        }
        return ans;
    }

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = queries.length;
        int[] ans = new int[n];
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indexes.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (queries[i] > indexes.size()) {
                ans[i] = -1;
            } else {
                ans[i] = indexes.get(queries[i] - 1);
            }
        }
        return ans;
    }

    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        // 这个map标识每个球的颜色
        Map<Integer, Integer> colors = new HashMap<>();
        // 这个map标识每种颜色各有多少
        Map<Integer, Integer> count = new HashMap<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int board = queries[i][0];
            int color = queries[i][1];
            if (colors.containsKey(board)) {
                // 要改色
                int preColor = colors.get(board);
                if (count.get(preColor) == 1) {
                    count.remove(preColor);
                } else {
                    count.put(preColor, count.get(preColor) - 1);
                }
            }
            colors.put(board, color);
            count.merge(color, 1, Integer::sum);
            ans[i] = count.size();
        }
        return ans;
    }

    public List<Boolean> getResults(int[][] queries) {
        int m = 0;
        for (int[] q : queries) {
            m = Math.max(m, q[1]);
        }
        m++;

        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(0, m));
        int[] t = new int[2 << (32 - Integer.numberOfLeadingZeros(m))];

        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int x = q[1];
            // x 左侧最近障碍物的位置
            int pre = set.floor(x - 1);
            if (q[0] == 1) {
                // x 右侧最近障碍物的位置
                int nxt = set.ceiling(x);
                set.add(x);
                // 更新 d[x] = x - pre
                update(t, 1, 0, m, x, x - pre);
                // 更新 d[nxt] = nxt - x
                update(t, 1, 0, m, nxt, nxt - x);
            } else {
                // 最大长度要么是 [0,pre] 中的最大 d，要么是 [pre,x] 这一段的长度
                int maxGap = Math.max(query(t, 1, 0, m, pre), x - pre);
                ans.add(maxGap >= q[2]);
            }
        }
        return ans;
    }

    // 把 i 处的值改成 val
    private void update(int[] t, int o, int l, int r, int i, int val) {
        if (l == r) {
            t[o] = val;
            return;
        }
        int m = (l + r) / 2;
        if (i <= m) {
            update(t, o * 2, l, m, i, val);
        } else {
            update(t, o * 2 + 1, m + 1, r, i, val);
        }
        t[o] = Math.max(t[o * 2], t[o * 2 + 1]);
    }

    // 查询 [0,R] 中的最大值
    private int query(int[] t, int o, int l, int r, int R) {
        if (r <= R) {
            return t[o];
        }
        int m = (l + r) / 2;
        if (R <= m) {
            return query(t, o * 2, l, m, R);
        }
        return Math.max(t[o * 2], query(t, o * 2 + 1, m + 1, r, R));
    }


    public static void main(String[] args) {
        DoubleWeeklyComp131 doubleWeeklyComp131 = new DoubleWeeklyComp131();
//        System.out.println(doubleWeeklyComp131.duplicateNumbersXOR(new int[]{1,2,3}));

//        int[] nums = {1, 3, 1, 7};
//        int[] queries = {1, 3, 2, 4};
//        System.out.println(doubleWeeklyComp131.occurrencesOfElement(nums, queries, 1));

//        int[][] queries = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
//        System.out.println(Arrays.toString(doubleWeeklyComp131.queryResults(4, queries)));

//        int[][] queries = {{1, 7}, {2, 7, 6}, {1, 2}, {2, 7, 5}, {2, 7, 6}};
//        System.out.println(doubleWeeklyComp131.getResults(queries));

        int[][] queries = {{1, 7}, {2, 7, 6}, {1, 2}, {2, 7, 5}, {2, 7, 6}};
        System.out.println(doubleWeeklyComp131.getResults(queries));

    }
}
