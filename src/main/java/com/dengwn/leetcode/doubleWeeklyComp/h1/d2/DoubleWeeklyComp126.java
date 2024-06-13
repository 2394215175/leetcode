package com.dengwn.leetcode.doubleWeeklyComp.h1.d2;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/7
 **/
public class DoubleWeeklyComp126 {

    public int sumOfEncryptedInt(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += encrypt(num);
        }
        return ans;
    }

    public int encrypt(int x) {
        int bit = 0;
        int max = 0;
        while (x > 0) {
            max = Math.max(x % 10, max);
            x /= 10;
            bit++;
        }
        int ans = 0;
        while (bit > 0) {
            ans *= 10;
            ans += max;
            bit--;
        }
        return ans;
    }

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        long[] ans = new long[m];
        int[][] temp = new int[n][2];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            temp[i] = new int[]{nums[i], i};
            sum += nums[i];
        }
        Arrays.sort(temp, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Set<Integer> target = new HashSet<>();
        int prev = 0;
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int k = queries[i][1];
            // 先标记index
            if (!target.contains(index)) {
                sum -= nums[index];
                target.add(index);
            }
            // 再找前k个最小的数
            for (int j = prev, l = 0; j < n && l < k; j++) {
                if (target.contains(temp[j][1])) {
                    continue;
                }
                l++;
                sum -= temp[j][0];
                target.add(temp[j][1]);
                prev = j + 1;
            }
            ans[i] = sum;
        }
        return ans;
    }

    public String minimizeStringValue(String s) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        int q = 0;
        for (char c : chars) {
            if (c == '?') {
                q++;
            } else {
                cnt[c - 'a']++;
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        for (int i = 0; i < 26; i++) {
            queue.add(new int[]{cnt[i], i});
        }

        int[] question = new int[q];
        for (int i = 0; i < q; i++) {
            int[] top = queue.poll();
            question[i] = top[1];
            top[0]++;
            queue.add(top);
        }
        Arrays.sort(question);

        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                chars[i] = (char) ('a' + question[index]);
                index++;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        DoubleWeeklyComp126 doubleWeeklyComp126 = new DoubleWeeklyComp126();

//        System.out.println(doubleWeeklyComp126.encrypt(10));

//        int[] nums = {1, 2, 2, 1, 2, 3, 1};
//        int[][] queries = {{1, 2}, {3, 3}, {4, 2}};
//        System.out.println(Arrays.toString(doubleWeeklyComp126.unmarkedSumArray(nums, queries)));

        System.out.println(doubleWeeklyComp126.minimizeStringValue("???"));

    }
}
