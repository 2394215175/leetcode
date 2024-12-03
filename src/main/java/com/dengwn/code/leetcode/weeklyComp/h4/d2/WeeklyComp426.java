package com.dengwn.code.leetcode.weeklyComp.h4.d2;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/12/3
 **/
public class WeeklyComp426 {
    public int smallestNumber(int n) {
        String len = Integer.toBinaryString(n);
        return (int) Math.pow(2, len.length()) - 1;
    }

    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> set = new HashMap<>();
        for (int num : nums) {
            sum += num;
            set.merge(num, 1, Integer::sum);
        }
        Arrays.sort(nums);
        for (int i = n - 1; i >= 0; i--) {
            int half = sum - nums[i];
            if (half % 2 != 0) {
                continue;
            }
            Integer times = set.get(half / 2);
            int needTimes = half / 2 == nums[i] ? 2 : 1;
            if (times != null && times >= needTimes) {
                return nums[i];
            }
        }
        return -1;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] ans = new int[n];
        int[] step = new int[m];
        // 建图
        List<Integer>[] edges1List = new ArrayList[n];
        List<Integer>[] edges2List = new ArrayList[m];
        for (int i = 0; i < n; i++) {
            edges1List[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            edges2List[i] = new ArrayList<>();
        }
        for (int[] edge : edges1) {
            edges1List[edge[0]].add(edge[1]);
            edges1List[edge[1]].add(edge[0]);
        }
        for (int[] edge : edges2) {
            edges2List[edge[0]].add(edge[1]);
            edges2List[edge[1]].add(edge[0]);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            step[i] = maxNodes(edges2List, i, k - 1);
            max = Math.max(max, step[i]);
        }
        for (int i = 0; i < n; i++) {
            ans[i] = maxNodes(edges1List, i, k) + max;
        }
        return ans;
    }

    public int maxNodes(List<Integer>[] edges, int start, int k) {
        if (k < 0) {
            return 0;
        }
        int step = 0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty() && step < k) {
            for (int i = queue.size(); i > 0; i--) {
                Integer cur = queue.poll();
                for (int next : edges[cur]) {
                    if (set.contains(next)) {
                        continue;
                    }
                    queue.add(next);
                    set.add(next);
                }
            }
            step++;
        }
        return set.size();
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] ans = new int[n];
        // 建图
        List<Integer>[] edges1List = new ArrayList[n];
        List<Integer>[] edges2List = new ArrayList[m];
        for (int i = 0; i < n; i++) {
            edges1List[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            edges2List[i] = new ArrayList<>();
        }
        for (int[] edge : edges1) {
            edges1List[edge[0]].add(edge[1]);
            edges1List[edge[1]].add(edge[0]);
        }
        for (int[] edge : edges2) {
            edges2List[edge[0]].add(edge[1]);
            edges2List[edge[1]].add(edge[0]);
        }
        boolean[] visited2 = new boolean[m];
        visited2[0] = true;
        boolean[] temp2 = new boolean[m];
        dfs(edges2List, visited2, 0, 0, temp2);
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (temp2[i]) {
                cnt++;
            }
        }
        cnt = Math.max(cnt, m - cnt);

        boolean[] visited1 = new boolean[n];
        visited1[0] = true;
        boolean[] temp1 = new boolean[n];
        dfs(edges1List, visited1, 0, 0, temp1);
        int cntT = 0;
        for (int i = 0; i < n; i++) {
            if (temp1[i]) {
                cntT++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (temp1[i]){
                ans[i] = cntT + cnt;
            }else {
                ans[i] = n - cntT + cnt;
            }
        }
        return ans;
    }

    public void dfs(List<Integer>[] edges, boolean[] visited, int cur, int step, boolean[] temp) {
        if (step % 2 == 0) {
            temp[cur] = true;
        }
        for (int next : edges[cur]) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            dfs(edges, visited, next, step + 1, temp);
            visited[next] = false;
        }
    }

    public static void main(String[] args) {
        WeeklyComp426 weeklyComp426 = new WeeklyComp426();

//        System.out.println(weeklyComp426.smallestNumber(4));

//        System.out.println(weeklyComp426.getLargestOutlier(new int[]{6, -31, 50, -35, 41, 37, -42, 13}));


        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}};
        System.out.println(Arrays.toString(weeklyComp426.maxTargetNodes(edges1, edges2)));
    }
}
