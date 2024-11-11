package com.dengwn.code.leetcode.weeklyComp.h4.d2;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/11/11
 **/
public class WeeklyComp423 {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int size = nums.size();
        boolean[] b = new boolean[size - k + 1];
        for (int i = 0; i <= size - k; i++) {
            b[i] = true;
            for (int j = 0; j < k - 1; j++) {
                if (nums.get(i + j) >= nums.get(i + j + 1)) {
                    b[i] = false;
                    break;
                }
            }
        }
        for (int i = k; i <= size - k; i++) {
            if (b[i] && b[i - k]) {
                return true;
            }
        }
        return false;
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int size = nums.size();
        int preCnt = 0;
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            cnt++;
            if (i == size - 1 || nums.get(i) >= nums.get(i + 1)) {
                ans = Math.max(ans, Math.max(cnt / 2, Math.min(preCnt, cnt)));
                preCnt = cnt;
                cnt = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp423 weeklyComp423 = new WeeklyComp423();

        System.out.println(weeklyComp423.hasIncreasingSubarrays(Arrays.asList(5, 8, -2, -1), 1));

    }
}
