package com.dengwn.code.leetcode.lcp;

/**
 * @author dengwenning
 * @since 2024/6/21
 **/
public class Lcp61 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];
        for (int i = 1; i < n; i++) {
            a[i - 1] = temperatureA[i] == temperatureA[i - 1] ? 0 : (temperatureA[i] - temperatureA[i - 1]) / Math.abs(temperatureA[i] - temperatureA[i - 1]);
            b[i - 1] = temperatureB[i] == temperatureB[i - 1] ? 0 : (temperatureB[i] - temperatureB[i - 1]) / Math.abs(temperatureB[i] - temperatureB[i - 1]);
        }
        int pre = -1;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == b[i]) {
                ans = Math.max(ans, i - pre);
            } else {
                pre = i;
            }
        }
        return ans;
    }

    public int temperatureTrend1(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int ans = 0;
        int same = 0;
        for (int i = 1; i < n; i++) {
            if (Integer.compare(temperatureA[i], temperatureA[i - 1]) == Integer.compare(temperatureB[i], temperatureB[i - 1])) {
                same++;
                ans = Math.max(ans, same);
            } else {
                same = 0;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
