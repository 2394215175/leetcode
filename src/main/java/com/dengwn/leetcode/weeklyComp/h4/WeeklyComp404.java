package com.dengwn.leetcode.weeklyComp.h4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengwenning
 * @since 2024/6/30
 **/
public class WeeklyComp404 {

    public int maxHeightOfTriangle(int red, int blue) {
        int ans1 = calc(red, blue);
        int ans2 = calc(blue, red);
        return Math.max(ans1, ans2);
    }

    private int calc(int red, int blue) {
        int ans = 0;
        boolean flag = true;
        while (true) {
            if (flag) {
                red -= ans;
            } else {
                blue -= ans;
            }
            if (red < 0 || blue < 0) {
                break;
            }
            ans++;
            flag = !flag;
        }
        return ans - 1;
    }

    public int maximumLength(int[] nums) {
        // 删除数组中的某些元素，使其偶数下标和奇数下表的奇偶性一致
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] %= 2;
        }
        // 全为1
        int ans0 = 0;
        int ans1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ans1++;
            } else {
                ans0++;
            }
        }
        // 01相间，10相间
        int ans01 = 0;
        int ans10 = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] + ans01) % 2 == 0) {
                ans01++;
            }
            if ((nums[i] + ans10) % 2 == 1) {
                ans10++;
            }
        }
        return Math.max(Math.max(ans0, ans1), Math.max(ans01, ans10));
    }


    public int maximumLength1(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] %= k;
        }
        int[][][] dp = new int[n][n + 1][2];
        // i 标识当前位置，j 表示前一个位置， 0表示上一个数不存在
        int ans = 0;
        dp[1][0][0] = 1;
        dp[1][0][1] = -1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 当前数需要和前一个数是一样的
                int cur = nums[i - 1];

            }
        }
        return ans;
    }


    public static void main(String[] args) {
        WeeklyComp404 weeklyComp404 = new WeeklyComp404();

//        System.out.println(weeklyComp404.maxHeightOfTriangle(4, 2));

        System.out.println(weeklyComp404.maximumLength1(new int[]{1, 4, 2, 3, 1, 4}, 3));
    }
}
