package com.dengwn.leetcode.doubleWeeklyComp;


import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * @author dengwn
 * @date: 2022-12-10
 */
public class DoubleWeeklyComp93 {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            boolean isNum = true;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) > '9') {
                    ans = Math.max(ans, str.length());
                    isNum = false;
                    break;
                }
            }
            if (isNum) {
                ans = Math.max(ans, Integer.parseInt(str));
            }
        }
        return ans;
    }

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int ans = Integer.MIN_VALUE;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            List<Integer> list1 = map.getOrDefault(edges[i][0], new ArrayList<>());
            list1.add(edges[i][1]);
            map.put(edges[i][0], list1);

            List<Integer> list2 = map.getOrDefault(edges[i][1], new ArrayList<>());
            list2.add(edges[i][0]);
            map.put(edges[i][1], list2);
        }

        for (int node = 0; node < vals.length; node++) {
            int val = vals[node];
            List<Integer> list = map.getOrDefault(node, new ArrayList<>());
            List<Integer> sizes = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                sizes.add(vals[list.get(i)]);
            }

            sizes.sort((o1, o2) -> o2 - o1);
            for (int i = 0; i < Math.min(list.size(), k); i++) {
                val += sizes.get(i);
            }
            ans = Math.max(ans, val);
        }

        return ans;
    }

    public int maxJump(int[] stones) {
        int length = stones.length;
        int ans = 0;
        if (length == 2) {
            return stones[1] - stones[0];
        }

        for (int i = 2; i < length; i += 2) {
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }
        for (int i = 3; i < length; i += 2) {
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }
        return ans;
    }

    public long minimumTotalCost(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int ans = 0;

        int index = 0;
        int pre = -1;
        for (int i = 1; i < length; i++) {
            if (nums1[i] == nums2[i]) {
                index++;
                if (index == 1) {
                    pre = nums2[i];
                }
                if (index == 2) {
                    nums1[i] = 0;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp93 doubleWeeklyComp93 = new DoubleWeeklyComp93();
        String[] strs = {"1", "01", "001", "0001"};
        System.out.println(doubleWeeklyComp93.maximumValue(strs));

        int[] vals = {0, -36, 4, 35, 27, -13};
        int[][] edges = {{5, 3}, {4, 3}, {0, 4}, {2, 4}, {0, 2}};
        int k = 1;
        System.out.println(doubleWeeklyComp93.maxStarSum(vals, edges, k));

        int[] stones = {0, 2, 4, 6, 8, 11};
        System.out.println(doubleWeeklyComp93.maxJump(stones));

        int[] nums1 = {2, 2, 2, 1, 3};
        int[] nums2 = {1, 2, 2, 3, 3};
        System.out.println(doubleWeeklyComp93.minimumTotalCost(nums1, nums2));
    }
}


