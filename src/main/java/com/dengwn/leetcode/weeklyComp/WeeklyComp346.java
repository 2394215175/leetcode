package com.dengwn.leetcode.weeklyComp;

import java.util.Stack;

/**
 * @author: dengwn
 * @date: 2023-05-22
 **/
public class WeeklyComp346 {
    public int minLength(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                stack.pop();
                continue;
            }
            if (c == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                stack.pop();
                continue;
            }
            stack.add(c);
        }
        return stack.size();
    }

    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - 1 - i]) {
                if (chars[i] > chars[n - 1 - i]) {
                    chars[i] = chars[n - 1 - i];
                } else {
                    chars[n - 1 - i] = chars[i];
                }
            }
        }
        return new String(chars);
    }

    public int punishmentNumber(int n) {
        int[] nums = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nums[i] = i * i;
        }
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            char[] chars = String.valueOf(nums[i]).toCharArray();
            if (dfs(chars, i, 0, 0)) {
                ans += nums[i];
            }
        }
        return ans;
    }

    private static boolean dfs(char[] s, int i, int p, int sum) {
        if (p == s.length) {
            return sum == i;
        }
        int x = 0;
        for (int j = p; j < s.length; j++) {
            x = x * 10 + s[j] - '0';
            if (dfs(s, i, j + 1, sum + x)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        WeeklyComp346 weeklyComp346 = new WeeklyComp346();

//        System.out.println(weeklyComp346.minLength("D"));

//        System.out.println(weeklyComp346.makeSmallestPalindrome("seven"));

        System.out.println(weeklyComp346.punishmentNumber(10));
    }


}
