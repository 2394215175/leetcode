package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d2;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: dengwn
 * @date: 2024-02-23
 **/
public class DoubleWeeklyComp124 {

    public int maxOperations(int[] nums) {
        int step = 1;
        int cnt = nums[0] + nums[1];
        for (int i = 2; i < nums.length; i += 2) {
            if (i + 1 >= nums.length) {
                break;
            }
            if (nums[i] + nums[i + 1] == cnt) {
                step++;
            } else {
                break;
            }
        }
        return step;
    }

    public String lastNonEmptyString(String s) {
        int[][] cnt = new int[26][2];
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            cnt[chars[i] - 'a'][0] = i;
            cnt[chars[i] - 'a'][1]++;
            max = Math.max(max, cnt[chars[i] - 'a'][1]);
        }

        Map<Integer, Character> map = new TreeMap<>();

        for (int i = 0; i < 26; i++) {
            if (cnt[i][1] == max) {
                map.put(cnt[i][0], (char) (i + 'a'));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            stringBuilder.append(entry.getValue());
        }
        return stringBuilder.toString();
    }

    /**
     * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：
     * 选择 nums 中最前面两个元素并且删除它们。
     * 选择 nums 中最后两个元素并且删除它们。
     * 选择 nums 中第一个和最后一个元素并且删除它们。
     * 一次操作的 分数 是被删除元素的和。
     * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
     * 请你返回按照上述要求 最多 可以进行的操作次数。
     *
     * @param nums
     * @return
     */
    public int maxOperations2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < n - 1; i++) {
            dp[i][0] = nums[i] + nums[i + 1];
        }
        return 0;
    }

    public int maxSelectedElements(int[] nums) {
        int[] cnt = new int[1000001];
        for (int num : nums) {
            cnt[num]++;
        }

        int left = 1;
        int right = 1;
        int max = 1;
        for (int i = 1; i < 1000001; i++) {
            if (cnt[i] > 0) {
                if (cnt[left] == 0) {
                    left = i;
                }
                right = i;
            } else {
                left = i;
            }

            if (cnt[left] > 1){
                max = Math.max(max, right - left + 2);
            }else {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp124 doubleWeeklyComp124 = new DoubleWeeklyComp124();
        int[] nums = {3, 2, 1, 4, 5};
        System.out.println(doubleWeeklyComp124.maxOperations(nums));

        System.out.println(doubleWeeklyComp124.lastNonEmptyString("aabcbbca"));

        int[] nums2 = {8,10,6,12,9,12,2,3,13,19,11,18,10,16};
        System.out.println(doubleWeeklyComp124.maxSelectedElements(nums2));
    }
}
