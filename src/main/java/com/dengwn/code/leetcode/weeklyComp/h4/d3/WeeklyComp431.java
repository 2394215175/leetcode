package com.dengwn.code.leetcode.weeklyComp.h4.d3;

import com.dengwn.code.leetcode.solution.TreeNode;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2025/1/5
 **/
public class WeeklyComp431 {

    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i];
                int gcd = nums[i];
                int lcm = nums[i];
                for (int k = i + 1; k <= j; k++) {
                    prod *= nums[k];
                    gcd = gcd(gcd, nums[k]);
                    lcm = lcm(lcm, nums[k]);
                }
                if (prod == lcm * gcd) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public long calculateScore(String s) {
        long ans = 0;
        char[] array = s.toCharArray();
        int n = array.length;
        Map<Character, LinkedList<Integer>> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = array[i];
            char d = (char) ((25 - (array[i] - 'a')) + 'a');
            if (cnt.containsKey(d)) {
                LinkedList<Integer> list = cnt.get(d);
                ans += i - list.getLast();
                list.removeLast();
                if (list.isEmpty()) {
                    cnt.remove(d);
                }
            } else {
                LinkedList<Integer> list = cnt.getOrDefault(c, new LinkedList<>());
                list.addLast(i);
                cnt.put(c, list);
            }
        }
        return ans;
    }

    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, Comparator.comparingInt(o -> o[0]));
        int n = coins.length;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cnt[i + 1] = (coins[i][1] - coins[i][0] + 1) * coins[i][2] + cnt[i];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int end = coins[i][1];
            int start = Math.max(end - k, 0);
            int index = binarySearch(coins, start);
            int endCnt = cnt[i + 1];
            int startCnt = index == -1 ? 0 : cnt[index] + (start - coins[index][0] + 1) * coins[index][2];
            ans = Math.max(ans, endCnt - startCnt);
        }
        return ans;
    }

    public int binarySearch(int[][] coins, int target) {
        int left = 0;
        int right = coins.length - 1;
        int result = -1; // 用于存储小于等于目标值的最近的那个数的索引

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (coins[mid][0] == target) {
                return mid; // 找到目标值，直接返回
            } else if (coins[mid][0] < target) {
                result = mid; // 更新结果为当前 mid
                left = mid + 1; // 继续在右半部分查找
            } else {
                right = mid - 1; // 继续在左半部分查找
            }
        }

        return result; // 返回小于等于目标值的最近的那个数的索引
    }

    public static void main(String[] args) {
        WeeklyComp431 weeklyComp431 = new WeeklyComp431();
//        int maxLength = weeklyComp431.maxLength(new int[]{2, 3, 4, 5, 6});
//        System.out.println(maxLength);

//        System.out.println(weeklyComp431.calculateScore("aczzx"));

        int[][] coins = {{8, 12, 13}, {29, 32, 2}, {13, 15, 2}, {40, 41, 18}, {42, 48, 18}, {33, 36, 11}, {37, 38, 6}};
        int k = 28;
        System.out.println(weeklyComp431.maximumCoins(coins, k));

    }
}
