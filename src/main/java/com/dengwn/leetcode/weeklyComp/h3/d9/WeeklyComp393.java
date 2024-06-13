package com.dengwn.leetcode.weeklyComp.h3.d9;

/**
 * @author: dengwn
 * @date: 2024-04-14
 **/
public class WeeklyComp393 {


    public String findLatestTime(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < 5; i++) {
            if (chars[i] == '?') {
                if (i == 0) {
                    if (chars[1] != '?' && chars[1] > '1') {
                        chars[i] = '0';
                    } else {
                        chars[i] = '1';
                    }
                }
                if (i == 1) {
                    if (chars[0] == '0') {
                        chars[i] = '9';
                    }
                    if (chars[0] == '1') {
                        chars[i] = '1';
                    }
                }
                if (i == 3) {
                    chars[i] = '5';
                }
                if (i == 4) {
                    chars[i] = '9';
                }
            }
        }
        return new String(chars);
    }


    public int maximumPrimeDifference(int[] nums) {
        boolean[] table = new boolean[101];
        table[1] = true;
        for (int i = 2; i < 101; i++) {
            if (!table[i]) {
                for (int j = 2; i * j < 101; j++) {
                    table[i * j] = true;
                }
            }
        }

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (table[nums[left]]) {
                left++;
            } else if (table[nums[right]]) {
                right--;
            } else {
                return right - left;
            }
        }
        return 0;
    }

    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给你一个整数 k 。
     * 你有无限量的每种面额的硬币。但是，你 不能 组合使用不同面额的硬币。
     * 返回使用这些硬币能制造的 第 kth 小 金额。
     * 1 <= k <= 2 * 109
     *
     * @param coins
     * @param k
     * @return
     */
    public long findKthSmallest(int[] coins, int k) {
        // k的值可能很大
        long left = 1;
        long right = 1;
        for (int coin : coins) {
            right *= coin;
        }
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = 0;
            // count 需要去重
            for (int coin : coins) {
                count += mid / coin;
            }
            
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return b == 0 ? a : gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }


    public static void main(String[] args) {
        WeeklyComp393 weeklyComp393 = new WeeklyComp393();

//        System.out.println(weeklyComp393.findLatestTime("?3:12"));

//        System.out.println(weeklyComp393.maximumPrimeDifference(new int[]{1, 7}));

        System.out.println(weeklyComp393.findKthSmallest(new int[]{3, 6, 9}, 3));
    }
}
