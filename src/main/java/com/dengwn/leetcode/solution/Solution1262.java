package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-06-19
 **/
public class Solution1262 {
    public int maxSumDivThree(int[] nums) {
        Queue<Integer> queue1 = new PriorityQueue();
        Queue<Integer> queue2 = new PriorityQueue();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                queue1.add(num);
            }
            if (num % 3 == 2) {
                queue2.add(num);
            }
        }

        if (sum % 3 == 0) {
            return sum;
        }
        if (sum % 3 == 2) {
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        int ans = queue1.isEmpty() ? 0 : sum - queue1.poll();
        if (queue2.size() > 1) {
            ans = Math.max(ans, sum - queue2.poll() - queue2.poll());
        }
        return ans;
    }

    public int maxSumDivThree1(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 1][3];
        f[0][1] = f[0][2] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i + 1][j] = Math.max(f[i][j], f[i][(j + nums[i]) % 3] + nums[i]);
            }
        }

        return f[n][0];

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(null instanceof String);
    }
}
