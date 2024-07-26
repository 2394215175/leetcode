package com.dengwn.leetcode.doubleWeeklyComp.h1.d3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengwenning
 * @since 2024/7/20
 **/
public class DoubleWeeklyComp135 {

    public String losingPlayer(int x, int y) {
        int ans = 0;
        while (x >= 0 && y >= 0) {
            x -= 1;
            y -= 4;
            ans++;
        }
        return ans % 2 == 0 ? "Alice" : "Bob";
    }

    public int minimumLength(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            while (cnt[i] >= 3) {
                cnt[i] -= 2;
            }
            ans += cnt[i];
        }
        return ans;
    }

    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < n / 2; i++) {
            int abs = Math.abs(nums[i] - nums[n - 1 - i]);
            diff.merge(abs, 1, Integer::sum);
        }
        int maxCnt = 0;
        int secondCnt = -1;
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            Integer cnt = entry.getValue();
            if (cnt > maxCnt) {
                secondCnt = maxCnt;
                maxCnt = cnt;
                continue;
            } if (cnt > secondCnt) {
                secondCnt = cnt;
            }
        }
        int ans = n;
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            Integer abs = entry.getKey();
            if (abs > k) {
                continue;
            }
            if (entry.getValue() == maxCnt || entry.getValue() == secondCnt) {
                ans = Math.min(ans, calc(nums, k, abs));
            }
        }
        return ans;
    }

    public int calc(int[] nums, int k, int diff) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            if (Math.abs(nums[i] - nums[n - 1 - i]) != diff) {
                int a = nums[i] + diff;
                int b = nums[i] - diff;
                int c = nums[n - 1 - i] + diff;
                int d = nums[n - 1 - i] - diff;
                if (isIn(a, 0, k) || isIn(b, 0, k) || isIn(c, 0, k) || isIn(d, 0, k)) {
                    ans++;
                } else {
                    ans += 2;
                }
            }
        }
        return ans;
    }

    public boolean isIn(int a, int l, int r) {
        return a >= l && a <= r;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp135 doubleWeeklyComp135 = new DoubleWeeklyComp135();
//        System.out.println(doubleWeeklyComp125.losingPlayer(1, 4));

        System.out.println(doubleWeeklyComp135.minChanges(new int[]{1, 1, 1, 1, 0, 0, 0, 5, 4, 3, 19, 17, 16, 15, 15, 15, 19, 19, 19, 19}, 20));
    }
}
