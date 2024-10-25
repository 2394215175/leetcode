package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d0;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-06-13
 **/
public class DoubleWeeklyComp106 {
    public boolean isFascinating(int n) {
        String s = "" + n + (n * 2) + (n * 3);
        int[] nums = new int[9];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - '1';
            if (index >= 0) {
                nums[index]++;
                if (nums[index] == 1) {
                    cnt++;
                } else {
                    return false;
                }
            }
        }
        return cnt == 9;
    }

    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int ans = 1;
        for (int i = 0; i < n - ans; i++) {
            for (int j = i + 1; j < n; j++) {
                int isSame = 0;
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(k + 1)) {
                        if (isSame == 1) {
                            ans = Math.max(ans, k - i + 1);
                            isSame++;
                            break;
                        }
                        isSame++;
                    }
                }
                if (isSame < 2) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    static final int MOD = 1000000007;

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                res[i] = nums[i] + d;
            } else {
                res[i] = nums[i] - d;
            }
        }
        Arrays.sort(res);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (i - (n - i - 1)) * res[i];
            ans %= MOD;

        }
        return (int) ans;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp106 doubleWeeklyComp106 = new DoubleWeeklyComp106();


//        System.out.println(doubleWeeklyComp106.isFascinating(783));

//        System.out.println(doubleWeeklyComp106.longestSemiRepetitiveSubstring("52233"));

        int[] nums = {1, 0};
        String s = "RL";
        int d = 2;
        System.out.println(doubleWeeklyComp106.sumDistance(nums, s, d));

    }

}
