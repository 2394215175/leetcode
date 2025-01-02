package com.dengwn.code.leetcode.solution.t1.h3.d8;

import com.dengwn.code.leetcode.solution.t0.h1.d9.Solution199;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author dengwenning
 * @since 2024/12/23
 **/
public class Solution1387 {
    public int getKth(int lo, int hi, int k) {
        int l = hi - lo + 1;
        Integer[] arr = new Integer[l];
        Arrays.setAll(arr, i -> i + lo);
        Arrays.sort(arr, (o1, o2) -> getTh(o1) - getTh(o2));
        return arr[k - 1];
    }

    public int getTh(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1387 solution1387 = new Solution1387();
        System.out.println(solution1387.getKth(12, 15, 2));
    }
}
