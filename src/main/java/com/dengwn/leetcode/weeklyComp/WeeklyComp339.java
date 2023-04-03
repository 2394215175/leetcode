package com.dengwn.leetcode.weeklyComp;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-04-02
 */
public class WeeklyComp339 {

    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int ans = 0;
        int left = 0;
        while (left < n) {
            if (chars[left] == '1') {
                left++;
                continue;
            }
            int mid = left;
            while (mid < n && chars[mid] == '0') {
                mid++;
            }
            int right = mid;
            while (right < n && chars[right] == '1') {
                right++;
            }
            ans = Math.max(ans, 2 * (Math.min(right - mid, mid - left)));
            left = right;

        }
        return ans;
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            max = Math.max(max, map.get(num));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 0) {
                    list.add(entry.getKey());
                    map.merge(entry.getKey(), -1, Integer::sum);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int sum = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
            sum += reward2[i];
        }
        Arrays.sort(diff);
        for (int i = n - 1; i > n - k; i--) {
            sum += diff[i];
        }
        return sum;
    }

    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[p] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Integer cur = queue.poll();
                if (k == 1) {
                    continue;

                }
                int left = Math.max(-(k - 1), k - 1 - cur * 2);
                int right = Math.min(k - 1, -(k - 1) + (n - cur - 1) * 2);
                while (left >= 0 && left < n && left <= right) {
                    if (!set.contains(left) && ans[left] > ans[cur] + 1) {
                        queue.offer(left);
                        ans[left] = ans[cur] + 1;
                    }
                    left += 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp339 weeklyComp339 = new WeeklyComp339();

//        System.out.println(weeklyComp339.findTheLongestBalancedSubstring("111"));
//
//        int[] nums = {1, 2, 3, 4};
//        System.out.println(weeklyComp339.findMatrix(nums));

        int n = 4;
        int p = 0;
        int[] banned = {1, 2};
        int k = 4;
        System.out.println(Arrays.toString(weeklyComp339.minReverseOperations(n, p, banned, k)));
    }
}


