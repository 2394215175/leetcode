package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-06-01
 **/
public class Solution2517 {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int left = 0;
        int right = (price[n - 1] - price[0]) / (k - 1);
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(price, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] price, int d, int k) {
        int start = price[0];
        int cnt = 1;
        for (int i : price) {
            if (i >= start + d) {
                start = i;
                cnt++;
            }
        }
        return cnt >= k;
    }

    public static void main(String[] args) {
        Solution2517 solution2517 = new Solution2517();
        int[] price = {7, 7, 7, 7};
        int k = 2;
        System.out.println(solution2517.maximumTastiness(price, k));
    }
}
