package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d0;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author dengwn
 * @date: 2023-03-18
 */
public class DoubleWeeklyComp100 {

    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        int ans = 0;
        int diff = money - children;
        while (diff >= 7 && ans < children) {
            diff -= 7;
            ans++;
        }
        if ((diff == 3 && ans == children - 1) || (diff > 0 && ans == children)) {
            ans--;
        }
        return ans;
    }

    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        for (int num : nums) {
            j += num > nums[j] ? 1 : 0;
        }
        return j;
    }

    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] == o2[0]) {
                return o1[1] < o2[1] ? -1 : 1;
            } else {
                return 1;
            }
        });

        for (int i = 0; i < n; i++) {
            queue.add(new int[]{nums[i], i});
        }
        long ans = 0;
        int size = 0;
        boolean[] isUsed = new boolean[n];
        while (size < n && !queue.isEmpty()) {
            int[] cur = queue.poll();
            int value = cur[0];
            int index = cur[1];
            if (!isUsed[index]) {
                ans += value;
                isUsed[index] = true;
                if (index > 0) {
                    isUsed[index - 1] = true;
                }
                if (index < n - 1) {
                    isUsed[index + 1] = true;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp100 doubleWeeklyComp100 = new DoubleWeeklyComp100();

        System.out.println(doubleWeeklyComp100.distMoney(20, 2));

        int[] nums = {1, 3, 5, 2, 1, 3, 1};
        System.out.println(doubleWeeklyComp100.maximizeGreatness(nums));

        int[] nums3 = {2, 1, 3, 4, 5, 2};
        System.out.println(doubleWeeklyComp100.findScore(nums3));
    }
}
