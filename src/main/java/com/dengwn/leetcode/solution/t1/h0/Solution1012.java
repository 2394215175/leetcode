package com.dengwn.leetcode.solution.t1.h0;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-03-20
 **/
public class Solution1012 {
    char s[];
    int memo[][];

    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        memo = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return n - f(0, 0, true, false);
    }

    int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            // isNum 为 true 表示得到了一个合法数字
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, mask, false, false);
        }
        // 如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; ++d) {
            // 枚举要填入的数字 d
            if ((mask >> d & 1) == 0) {
                // d 不在 mask 中
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }

        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1012 solution1012 = new Solution1012();
        System.out.println(solution1012.numDupDigitsAtMostN(1000));
    }

}
