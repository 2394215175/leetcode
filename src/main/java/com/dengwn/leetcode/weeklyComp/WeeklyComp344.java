package com.dengwn.leetcode.weeklyComp;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-05-07
 */
public class WeeklyComp344 {

    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> pre = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                pre.add(nums[j]);
            }
            Set<Integer> end = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                end.add(nums[j]);
            }
            ans[i] = pre.size() - end.size();
        }
        return ans;
    }

    public int[] colorTheArray(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        int[] nums = new int[n];
        int[] pre = new int[n];
        int[] end = new int[n];
        if (n == 1) {
            return ans;
        }
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int index = query[0];
            int color = query[1];
            nums[index] = color;

            if (index > 0 && nums[index - 1] == color) {
                pre[index] = pre[index - 1] + 1;
            }

            if (index < n - 1 && nums[index + 1] == color) {
                end[index] = pre[index + 1] + 1;
            }
            ans[i] = pre[index] + end[index];
        }
        return ans;
    }

    int ans = 0;

    public int minIncrements(int n, int[] cost) {
        int left = 0;
        int right = 0;
        int ans = 0;
        while (n > 0) {
            for (int i = n - 1; i > n / 2; i -= 2) {
                int l = cost[i - 1] + left;
                int r = cost[i] + right;
                if (r > l) {
                    ans += r - l;
                    cost[i - 1] = cost[i];
                    left = 2*cost[i-1];
                } else {
                    ans += l - r;
                    cost[i] = cost[i - 1];
                }
            }
            n /= 2;
        }
        return ans;
    }


    public static void main(String[] args) {
//        FrequencyTracker frequencyTracker = new FrequencyTracker();
//        frequencyTracker.add(5);
//        frequencyTracker.add(5);
//        System.out.println(frequencyTracker.hasFrequency(1));
//        System.out.println(frequencyTracker.hasFrequency(2));
//        frequencyTracker.add(6);
//        frequencyTracker.add(5);
//        frequencyTracker.add(1);

        WeeklyComp344 weeklyComp344 = new WeeklyComp344();
//        int n = 4;
//        int[][] queries = {{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}};
//        System.out.println(Arrays.toString(weeklyComp344.colorTheArray(n, queries)));

        int n = 7;
        int[] cost = {1, 100, 1, 1, 1, 100, 100};
        System.out.println(weeklyComp344.minIncrements(n, cost));
    }
}

class FrequencyTracker {

    HashMap<Integer, Integer> map;
    HashMap<Integer, List<String>> listHashMap;

    public FrequencyTracker() {
        map = new HashMap<>();
        listHashMap = new HashMap<>();
    }

    public void add(int number) {
        Integer pre = map.getOrDefault(number, 0);
        map.put(number, pre + 1);
        List<String> list = listHashMap.get(pre);

        if (list != null) {
            list.remove(String.valueOf(number));
        }
        List<String> newList = listHashMap.getOrDefault(pre + 1, new ArrayList<>());
        newList.add(String.valueOf(number));
        listHashMap.put(pre + 1, newList);
    }

    public void deleteOne(int number) {
        Integer pre = map.get(number);
        if (pre == null || pre == 0) {
            return;
        }
        map.put(number, pre - 1);
        List<String> list = listHashMap.get(pre);
        list.remove(String.valueOf(number));
        listHashMap.put(pre, list);
        List<String> newList = listHashMap.getOrDefault(pre - 1, new ArrayList<>());
        newList.add(String.valueOf(number));
        listHashMap.put(pre - 1, newList);
    }


    public boolean hasFrequency(int frequency) {
        List<String> strings = listHashMap.getOrDefault(frequency, new ArrayList<>());
        return !strings.isEmpty();
    }
}
