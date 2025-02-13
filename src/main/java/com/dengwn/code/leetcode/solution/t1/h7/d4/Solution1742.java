package com.dengwn.code.leetcode.solution.t1.h7.d4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2022-11-23
 **/
public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] cnt = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            cnt[calculateSize(i)]++;
        }
        int ans = 0;
        for (int i = 0; i < 50; i++) {
            ans = Math.max(ans, cnt[i]);
        }
        return ans;
    }

    public int calculateSize(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
