package com.dengwn.leetcode.weeklyComp.h4.d1;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/10/6
 **/
public class WeeklyComp418 {

    public int maxGoodNumber(int[] nums) {
        int length = nums.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = Integer.toBinaryString(nums[i]);
        }
        int a = Integer.parseInt(strs[0] + strs[1] + strs[2], 2);
        int b = Integer.parseInt(strs[0] + strs[2] + strs[1], 2);
        int c = Integer.parseInt(strs[1] + strs[0] + strs[2], 2);
        int d = Integer.parseInt(strs[1] + strs[2] + strs[0], 2);
        int e = Integer.parseInt(strs[2] + strs[0] + strs[1], 2);
        int f = Integer.parseInt(strs[2] + strs[1] + strs[0], 2);

        return Math.max(Math.max(Math.max(a, b), Math.max(c, d)), Math.max(e, f));
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] invocation : invocations) {
            int a = invocation[0];
            int b = invocation[1];
            graph[a].add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] bugs = new boolean[n];
        bugs[k] = true;
        queue.offer(k);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Integer cur = queue.poll();
                for (Integer next : graph[cur]) {
                    if (bugs[next]) {
                        continue;
                    }
                    bugs[next] = true;
                    queue.offer(next);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (bugs[i]) {
                continue;
            }
            queue.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!bugs[i]) {
                for (int v : graph[i]) {
                    if (bugs[v]) {
                        List<Integer> ans = new ArrayList<>();
                        for (int j = 0; j < n; j++) {
                            ans.add(j);
                        }
                        return ans;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!bugs[i]) {
                res.add(i);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        WeeklyComp418 weeklyComp418 = new WeeklyComp418();

//        System.out.println(weeklyComp418.maxGoodNumber(new int[]{2, 8, 16}));


        System.out.println(weeklyComp418.remainingMethods(3, 2, new int[][]{{1, 0}, {2, 0}}));

    }
}
