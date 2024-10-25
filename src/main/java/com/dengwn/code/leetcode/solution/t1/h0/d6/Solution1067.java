package com.dengwn.code.leetcode.solution.t1.h0.d6;

/**
 * @author: dengwn
 * @date: 2023-05-05
 **/
public class Solution1067 {
    public int digitsCount(int d, int low, int high) {
        return count(high, d) - count(low - 1, d);
    }

    /* 计算数字 d 在 1-n 中出现的次数。 */
    public int count(int n, int d) {
        int cnt = 0;
        for (int i = 1; n / i != 0; i *= 10) {
            int k = n / i;
            // 高位的数字。
            int high = k / 10;
            if (d == 0) {
                if (high != 0) {
                    high--;
                } else {
                    break;
                }
            }
            cnt += high * i;
            // 当前位的数字。
            int cur = k % 10;
            if (cur > d) {
                cnt += i;
            } else if (cur == d) {
                // n - k * i 为低位的数字。
                cnt += n - k * i + 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution1067 solution1067 = new Solution1067();
//        System.out.println(solution1067.digitsCount(8, 10, 8877));

        System.out.println(solution1067.digitsCount(3, 100, 250));

        int cnt = 0;
        for (int i = 1; i <= 13; i++) {
            if (String.valueOf(i).contains("1")) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
