package com.dengwn.code.leetcode.weeklyComp.h4.d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/10/21
 **/
public class WeeklyComp420 {

    public List<String> stringSequence(String target) {
        List<String> res = new ArrayList<>();
        int n = target.length();
        char[] chars = target.toCharArray();
        char[] ans = new char[n];
        Arrays.fill(ans, ' ');
        for (int i = 0; i < n; i++) {
            ans[i] = 'a';
            res.add(String.valueOf(ans).replace(" ", ""));
            while (ans[i] != chars[i]) {
                ans[i] += 1;
                res.add(String.valueOf(ans).replace(" ", ""));
            }
        }
        return res;
    }

    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int[][] cnt = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            cnt[i + 1] = Arrays.copyOf(cnt[i], 26);
            cnt[i + 1][s.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + k; j <= n; j++) {
                for (int l = 0; l < 26; l++) {
                    if (cnt[j][l] - cnt[i][l] >= k) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int pre = nums[n - 1];
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= pre){
                pre = nums[i];
                continue;
            }
            boolean isChanged = false;
            int max = 1;
            for (int j = 2; j <= Math.sqrt(nums[i]); j++) {
                if (nums[i] % j != 0){
                    continue;
                }
                if (nums[i] / j <= pre){
                    isChanged = true;
                    max = Math.max(max, nums[i] / j);
                }
                if (j <= pre){
                    isChanged = true;
                    max = Math.max(max, j);
                }
            }
            pre = max;
            ans++;
            if (!isChanged){
                return -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp420 weeklyComp420 = new WeeklyComp420();

//        System.out.println(weeklyComp420.stringSequence("abcd"));

//        System.out.println(weeklyComp420.numberOfSubstrings("abacb", 2));

        System.out.println(weeklyComp420.minOperations(new int[]{105,11}));
    }
}
