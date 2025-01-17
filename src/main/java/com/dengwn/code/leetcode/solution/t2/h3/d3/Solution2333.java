package com.dengwn.code.leetcode.solution.t2.h3.d3;


import java.util.*;

/**
 * @author dengwenning
 * @since 2024/7/2
 **/
public class Solution2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        treeMap.put(0L, 0L);
        for (int i = 0; i < n; i++) {
            long d = Math.abs(nums1[i] - nums2[i]);
            treeMap.merge(d, 1L, Long::sum);
        }
        long ans = 0;
        long diff = k1 + k2;
        while (treeMap.size() >= 2 && diff > 0) {
            Map.Entry<Long, Long> first = treeMap.pollLastEntry();
            Map.Entry<Long, Long> second = treeMap.pollLastEntry();
            long nums = (first.getKey() - second.getKey()) * first.getValue();
            if (diff >= nums) {
                diff -= nums;
                treeMap.put(second.getKey(), first.getValue() + second.getValue());
            } else {
                long mod = diff % first.getValue();
                long prod = diff / first.getValue();
                treeMap.put(Math.max(0, first.getKey() - prod), first.getValue() - mod);
                treeMap.put(Math.max(0, first.getKey() - prod - 1), mod);
                treeMap.merge(second.getKey(), second.getValue(), Long::sum);
                diff = 0;
            }
        }

        while (!treeMap.isEmpty()) {
            Map.Entry<Long, Long> entry = treeMap.pollLastEntry();
            ans += entry.getKey() * entry.getKey() * entry.getValue();
        }

        return ans;
    }

    public long minSumSquareDiff1(int[] a, int[] nums2, int k1, int k2) {
        int n = a.length, k = k1 + k2;
        long ans = 0L, sum = 0L;
        for (int i = 0; i < n; ++i) {
            a[i] = Math.abs(a[i] - nums2[i]);
            sum += a[i];
            ans += (long) a[i] * a[i];
        }
        if (sum <= k) return 0; // 所有 a[i] 均可为 0
        Arrays.sort(a);
        for (int i = n - 1; ; --i) {
            int m = n - i;
            long v = a[i], c = m * (v - (i > 0 ? a[i - 1] : 0));
            ans -= v * v;
            if (c < k) {
                k -= c;
                continue;
            }
            v -= k / m;
            return ans + k % m * (v - 1) * (v - 1) + (m - k % m) * v * v;
        }
    }

    public static void main(String[] args) {
        Solution2333 solution2333 = new Solution2333();
        int[] nums1 = {11, 12, 13, 14, 15};
        int[] nums2 = {13, 16, 16, 12, 14};
        int k1 = 3;
        int k2 = 6;
        System.out.println(solution2333.minSumSquareDiff1(nums1, nums2, k1, k2));
    }
}
