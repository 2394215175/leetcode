package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-11-25
 **/
public class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    public boolean canBeEqual1(int[] target, int[] arr) {
        int n = arr.length, tot = 0;
        int[] cnt = new int[1010];
        for (int i = 0; i < n; i++) {
            if (++cnt[target[i]] == 1) {
                tot++;
            }
            if (--cnt[arr[i]] == 0) {
                tot--;
            }
        }
        return tot == 0;
    }
}
