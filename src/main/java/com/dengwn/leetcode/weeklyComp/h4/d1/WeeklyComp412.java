package com.dengwn.leetcode.weeklyComp.h4.d1;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/8/26
 **/
public class WeeklyComp412 {

    int MOD = 1000000007;

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        long mul = multiplier;
        if (multiplier == 1) {
            return nums;
        }
        int n = nums.length;
        int[] res = new int[n];
        int max = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> (int)((o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]) % MOD));
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            pq.offer(new long[]{nums[i], i});
        }
        while (k > 0) {
            long[] min = pq.poll();
            if (min[0] > max) {
                pq.offer(new long[]{min[0], min[1]});
                break;
            }
            pq.offer(new long[]{min[0] * mul, min[1]});
            k--;
        }
        int i = 0;
        while (!pq.isEmpty()) {
            long[] min = pq.poll();
            int times = k / n + (i < k % n ? 1 : 0);
            res[(int) min[1]] = (int) mid(min[0], mul, times);
            i++;
        }

        return res;
    }

    public long mid(long ori, long mul, int times) {
        ori %= MOD;
        while (times > 0) {
            if ((times & 1) == 1) {
                ori *= mul;
                ori %= MOD;
            }
            mul *= mul;
            mul %= MOD;
            times >>= 1;
        }
        return ori % MOD;
    }


    public int countPairs(int[] nums) {
        // key 前面出现过的交换
        // value 出现几次
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            ans += map.getOrDefault(num, 0);
            List<Integer> list = new ArrayList<>();
            list.add(num);
            for (int i = 0; i < 8; i++) {
                for (int j = i + 1; j < 8; j++) {
                    list.add(swap(num, i, j));
                }
            }
            int size = list.size();
            for (int m = 0; m < size; m++) {
                for (int i = 0; i < 8; i++) {
                    for (int j = i + 1; j < 8; j++) {
                        list.add(swap(list.get(m), i, j));
                    }
                }
            }
            Set<Integer> set = new HashSet<>(list);
            for (Integer i : set) {
                map.merge(i, 1, Integer::sum);
            }
        }
        return ans;
    }

    public int swap(int num, int i, int j) {
        int[] arr = new int[8];
        for (int k = 7; k >= 0; k--) {
            arr[k] = num % 10;
            num /= 10;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        int ans = 0;
        for (int k = 0; k < 8; k++) {
            ans *= 10;
            ans += arr[k];
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp412 weeklyComp412 = new WeeklyComp412();

        int[] nums = {66307295, 441787703, 589039035, 322281864};
        int k = 900900704;
        int multiplier = 641725;
        System.out.println(Arrays.toString(weeklyComp412.getFinalState(nums, k, multiplier)));

//        int[] nums = {1023, 2310, 2130, 213};
//        System.out.println(weeklyComp412.countPairs(nums));
    }
}
