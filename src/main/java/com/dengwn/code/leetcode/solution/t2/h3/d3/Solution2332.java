package com.dengwn.code.leetcode.solution.t2.h3.d3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/9/18
 **/
public class Solution2332 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int n = buses.length;
        int m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        // 当前是第几辆车
        int i = 0;
        // 下一辆车的第一个人
        int j = 0;
        int k = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < n) {
            k = capacity;
            while (j < m && passengers[j] <= buses[i] && k > 0) {
                set.add(passengers[j]);
                j++;
                k--;
            }
            i++;
        }

        int ans = k > 0 ? buses[n - 1] : passengers[j - 1];
        while (ans > 0) {
            if (!set.contains(ans)) {
                break;
            }
            ans--;
        }
        // 最后一辆车上有多少人
        return ans;
    }


    public static void main(String[] args) {
        Solution2332 solution2332 = new Solution2332();
        int[] buses = {2, 3};
        int[] passengers = {2, 3};
        int capacity = 2;
        System.out.println(solution2332.latestTimeCatchTheBus(buses, passengers, capacity));
    }
}
