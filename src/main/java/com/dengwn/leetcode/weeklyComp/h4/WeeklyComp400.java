package com.dengwn.leetcode.weeklyComp.h4;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/2
 **/
public class WeeklyComp400 {

    public int minimumChairs(String s) {
        int ans = 0;
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                sum++;
                ans = Math.max(ans, sum);
            } else {
                sum--;
            }
        }
        return ans;
    }

    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        int ans = meetings[0][0] - 1;
        int preMax = meetings[0][1];
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > preMax + 1) {
                ans += meetings[i][0] - preMax - 1;
            }
            preMax = Math.max(preMax, meetings[i][1]);
        }
        ans += days - preMax;
        return ans;
    }

    public String clearStars(String s) {
        int n = s.length();
        Stack<Integer>[] lists = new Stack[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new Stack<>();
        }
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (array[i] == '*') {
                for (int j = 0; j < 26; j++) {
                    Stack<Integer> stack = lists[j];
                    if (!stack.isEmpty()) {
                        Integer index = stack.pop();
                        array[index] = '0';
                        array[i] = '0';
                        break;
                    }
                }
            } else {
                lists[array[i] - 'a'].add(i);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : array) {
            if (c != '0') {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            ans = Math.min(ans, Math.abs(x - k));
            for (int j = i; j >= 0 && (x & nums[j]) != nums[j]; j--) {
                nums[j] &= x;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp400 weeklyComp400 = new WeeklyComp400();


//        int[][] meetings = {{1, 3}, {5, 7}, {9, 10}};
//        int day = 10;
//        System.out.println(weeklyComp400.countDays(day, meetings));

        System.out.println(weeklyComp400.clearStars("d*o*"));
    }
}
