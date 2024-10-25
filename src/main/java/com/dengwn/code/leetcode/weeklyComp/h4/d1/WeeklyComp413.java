package com.dengwn.code.leetcode.weeklyComp.h4.d1;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/9/1
 **/
public class WeeklyComp413 {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int a1 = coordinate1.charAt(0) - 'a';
        int a2 = coordinate1.charAt(1) - '1';
        int b1 = coordinate2.charAt(0) - 'a';
        int b2 = coordinate2.charAt(1) - '1';
        return (a1 + a2) % 2 == (b1 + b2) % 2;
    }

    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int dis = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            if (pq.size() < k) {
                pq.offer(dis);
            } else {
                Integer max = pq.poll();
                pq.offer(Math.min(max, dis));
            }
            if (pq.size() < k) {
                res[i] = -1;
            } else {
                res[i] = pq.peek();
            }
        }
        return res;
    }


    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] dp = new int[n][m];
        int max = 0;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = grid.get(i).get(j);
                max = Math.max(max, dp[i][j]);
                List<Integer> list = map.getOrDefault(dp[i][j], new ArrayList<>());
                list.add(i);
                map.put(dp[i][j], list);
            }
        }
        char[] j = new char[n];
        Arrays.fill(j, '0');
        return dfs(101, j, map);
    }

    public int dfs(int i, char[] j, TreeMap<Integer, List<Integer>> map) {
        if (i == 0) {
            return 0;
        }
        int ans = dfs(i - 1, j, map);
        Map.Entry<Integer, List<Integer>> entry = map.pollLastEntry();
        Integer key = entry.getKey();
        List<Integer> value = entry.getValue();
        for (Integer v : value) {
            // 不能选
            if (j[v] == '1') {
                continue;
            }
            // 能选
            j[v] = '1';
            ans = Math.max(ans, dfs(key, j, map) + key);
            j[v] = '0';
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp413 wc = new WeeklyComp413();

        List<List<Integer>> grid = new ArrayList<>();
//        grid.add(Arrays.asList(1, 2, 3));
//        grid.add(Arrays.asList(4, 3, 2));
//        grid.add(Arrays.asList(1, 1, 1));

        grid.add(Arrays.asList(8, 7, 6));
        grid.add(Arrays.asList(8, 3, 2));

//        grid.add(Arrays.asList(5));
//        grid.add(Arrays.asList(7));
//        grid.add(Arrays.asList(19));
//        grid.add(Arrays.asList(5));

//        grid.add(Arrays.asList(8, 11, 3));
//        grid.add(Arrays.asList(17, 7, 3));
//        grid.add(Arrays.asList(13, 20, 3));
//        grid.add(Arrays.asList(3, 17, 20));

//        grid.add(Arrays.asList(13, 14, 14));
//        grid.add(Arrays.asList(14, 18, 18));
//        grid.add(Arrays.asList(20, 14, 20));
//        grid.add(Arrays.asList(20, 4, 14));
        System.out.println(wc.maxScore(grid));
    }
}
