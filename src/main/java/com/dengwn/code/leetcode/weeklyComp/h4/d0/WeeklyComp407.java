package com.dengwn.code.leetcode.weeklyComp.h4.d0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dengwenning
 * @since 2024/7/21
 **/
public class WeeklyComp407 {

    public int minChanges(int n, int k) {
        int ans = 0;
        while (k > 0 || n > 0) {
            int lk = k % 2;
            int ln = n % 2;
            if (lk == 1 && ln == 0) {
                return -1;
            }
            if (lk == 0 && ln == 1) {
                ans++;
            }
            k /= 2;
            n /= 2;
        }
        return ans;
    }

    Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public boolean doesAliceWin(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                cnt++;
            }
        }
        return cnt > 0;
    }

    public int maxOperations(String s) {
        int cnt1 = 0;
        int n = s.length();
        int ans = 0;
        boolean isAdd = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt1++;
                isAdd = true;
            }
            if (s.charAt(i) == '0' && isAdd) {
                ans += cnt1;
                isAdd = false;
            }
        }
        return ans;
    }

    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = target[i] - nums[i];
        }
        long ans = 0;
        ans += Math.abs(diff[0]);
        int a = Integer.compare(diff[0], 0);
        for (int i = 1; i < n; i++) {
            // 等于0也是相当于不相同
            // 符号不相同
            if (a != Integer.compare(diff[i], 0)) {
                a = Integer.compare(diff[i], 0);
                ans += Math.abs(diff[i]);
            } else {
                // 符号相同
                ans += Math.max(Math.abs(diff[i]) - Math.abs(diff[i - 1]), 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp407 weeklyComp407 = new WeeklyComp407();

//        System.out.println(weeklyComp407.minChanges(13, 4));

        int[] nums = {9, 2, 6, 10, 4, 8, 3, 4, 2, 3};
        int[] target = {9, 5, 5, 1, 7, 9, 8, 7, 6, 5};
        System.out.println(weeklyComp407.minimumOperations(nums, target));



    }

}
