package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d0;


import java.util.*;

/**
 * @author dengwn
 * @date: 2023-04-01
 */
public class DoubleWeeklyComp101 {

    public int minNumber(int[] nums1, int[] nums2) {
        int[] nums = new int[10];
        for (int i : nums1) {
            nums[i]++;
        }
        for (int i : nums2) {
            nums[i]++;
        }
        for (int i = 1; i < 10; i++) {
            if (nums[i] == 2) {
                return i;
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums1[0] < nums2[0] ? nums1[0] * 10 + nums2[0] : nums2[0] * 10 + nums1[0];
    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        int[] dp = new int[s.length() + 1];
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            char c = s.charAt(i - 1);
            Integer grade = map.getOrDefault(c, c - 'a' + 1);
            dp[i] = Math.max(dp[i - 1] + grade, grade);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], t -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], t -> new ArrayList<>()).add(edge[0]);
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int[] dist = new int[n];
            dist[i] = 1;
            while (!queue.isEmpty()) {
                for (int j = queue.size(); j > 0; j--) {
                    Integer cur = queue.poll();
                    for (Integer index : lists[cur]) {
                        if (dist[index] == 0) {
                            dist[index] = dist[cur] + 1;
                            queue.offer(index);
                        } else if (dist[index] != dist[cur] - 1) {
                            min = Math.min(min, dist[cur] + dist[index] - 1);
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp101 doubleWeeklyComp101 = new DoubleWeeklyComp101();
//
//        int[] nums1 = {6, 4, 3, 7, 2, 1, 8, 5};
//        int[] nums2 = {6, 8, 5, 3, 1, 7, 4, 2};
//        System.out.println(doubleWeeklyComp101.minNumber(nums1, nums2));
//
//        String s = "abc";
//        String chars = "abc";
//        int[] vals = {-1, -1, -1};
//        System.out.println(doubleWeeklyComp101.maximumCostSubstring(s, chars, vals));

        int n = 6;
        int[][] edges = {{4, 1}, {5, 1}, {3, 2}, {5, 0}, {4, 0}, {3, 0}, {2, 1}};
        System.out.println(doubleWeeklyComp101.findShortestCycle(n, edges));
    }
}
