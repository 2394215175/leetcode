package com.dengwn.code.leetcode.weeklyComp.h3.d2;

import java.util.*;

/**
 * @author dengwn
 * @date: 2022-12-11
 */
public class WeeklyComp323 {
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        for (int[] g : grid) {
            Arrays.sort(g);
        }
        for (int i = grid[0].length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        return ans;
    }

    public int longestSquareStreak(int[] nums) {
        int ans = -1;
        Arrays.sort(nums);

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int size = 1;
            while (true) {
                if (set.contains(n * n)) {
                    n = n * n;
                    size++;
                } else {
                    break;
                }
            }
            if (size >= 2) {
                ans = Math.max(ans, size);
            }
        }
        return ans;
    }

    public int[] maxPoints(int[][] grid, int[] queries) {

        int length = queries.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = bfs(grid, queries[i]);
        }
        return res;
    }

    public int bfs(int[][] grid, int k) {
        if (grid[0][0] >= k) {
            return 0;
        }
        int m = grid[0].length;
        int n = grid.length;
        Set<Integer> visited = new HashSet<>();
        Queue<Set<Integer>> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        queue.add(set);

        while (!queue.isEmpty()) {
            Set<Integer> cur = queue.poll();
            Set<Integer> next = new HashSet<>();
            visited.addAll(cur);
            for (Integer integer : cur) {
                int i = integer / m;
                int j = integer % m;
                if (!visited.contains(integer + 1) && j + 1 < m && grid[i][j + 1] < k) {
                    next.add(integer + 1);
                }
                if (!visited.contains(integer - 1) && j - 1 > 0 && grid[i][j - 1] < k) {
                    next.add(integer - 1);
                }
                if (!visited.contains(integer + m) && i + 1 < n && grid[i + 1][j] < k) {
                    next.add(integer + m);
                }
                if (!visited.contains(integer - m) && i - 1 > 0 && grid[i - 1][j] < k) {
                    next.add(integer - m);
                }
            }
            if (!next.isEmpty()) {
                queue.add(next);
            }
        }
        return visited.size();
    }

    public static void main(String[] args) {
        WeeklyComp323 weeklyComp323 = new WeeklyComp323();

        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        System.out.println(weeklyComp323.deleteGreatestValue(grid));

        int[] nums = {2, 3, 5, 6, 7};
        System.out.println(weeklyComp323.longestSquareStreak(nums));

        int[][] grid1 = {{249472, 735471, 144880, 992181, 760916, 920551, 898524, 37043, 422852, 194509, 714395, 325171},
                {295872, 922051, 900801, 634980, 644237, 912433, 857189, 98466, 725226, 984534, 370121, 399006},
                {618420, 573065, 587011, 298153, 694872, 12760, 880413, 593508, 474772, 291113, 852444, 77998},
                {67650, 426517, 146447, 190319, 379151, 184754, 479219, 106819, 138473, 865661, 799297, 228827},
                {390392, 789371, 772048, 730506, 7144, 862164, 650590, 21524, 879440, 396198, 408897, 851020},
                {932044, 662093, 436861, 246956, 128943, 167432, 267483, 148325, 458128, 418348, 900594, 831373},
                {742255, 795191, 598857, 441846, 243888, 777685, 313717, 560586, 257220, 488025, 846817, 554722},
                {252507, 621902, 87704, 599753, 651175, 305330, 620166, 631193, 385405, 183376, 432598, 706692},
                {984416, 996917, 586571, 324595, 784565, 300514, 101313, 685863, 703194, 729430, 732044, 349877},
                {155629, 290992, 539879, 173659, 989930, 373725, 701670, 992137, 893024, 455455, 454886, 559081},
                {252809, 641084, 632837, 764260, 68790, 732601, 349257, 208701, 613650, 429049, 983008, 76324},
                {918085, 126894, 909148, 194638, 915416, 225708, 184408, 462852, 40392, 964501, 436864, 785076},
                {875475, 442333, 111818, 494972, 486734, 901577, 46210, 326422, 603800, 176902, 315208, 225178},
                {171174, 458473, 744971, 872087, 680060, 95371, 806370, 322605, 349331, 736473, 306720, 556064},
                {207705, 587869, 129465, 543368, 840821, 977451, 399877, 486877, 327390, 8865, 605705, 481076}};

        int[] queries = {690474, 796832, 913701, 939418, 46696, 266869, 150594, 948153, 718874};
        System.out.println(weeklyComp323.maxPoints(grid1, queries));

        Allocator allocator = new Allocator(162);
        System.out.println(allocator.allocate(83, 104));
        System.out.println(allocator.free(15));
        System.out.println(allocator.allocate(1, 76));
        System.out.println(allocator.free(104));
        System.out.println(allocator.allocate(6, 7));
        System.out.println(allocator.free(15));
        System.out.println(allocator.allocate(15, 127));
        System.out.println(allocator.free(4));
        System.out.println(allocator.free(127));
        System.out.println(allocator.free(75));
    }


}

class Allocator {
    int[] nums;

    public Allocator(int n) {
        nums = new int[n];
        Arrays.fill(nums, 2000);
    }

    public int allocate(int size, int mID) {
        if (size > nums.length) {
            return -1;
        }

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int ans = -1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2000 && ans == -1) {
                ans = i;
            }

            if (nums[i] == 2000) {
                index++;
            }
            if (nums[i] != 2000 || i == nums.length - 1) {
                map.put(ans, index);
                ans = -1;
                index = 0;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= size) {
                for (int i = entry.getKey(); i < size + entry.getKey(); i++) {
                    nums[i] = mID;
                }
                return entry.getKey();
            }
        }

        return -1;
    }

    public int free(int mID) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mID) {
                nums[i] = 2000;
                size++;
            }
        }
        return size;
    }
}
