package com.dengwn.leetcode.interview;

import lombok.val;

import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-04-12
 **/
public class Huawei20230411 {
    public String wordsPuzzle(String riddle, String ansLibrary) {
        String[] riddles = riddle.split(",");
        String[] libraries = ansLibrary.split(",");
        StringBuilder sb = new StringBuilder();
        for (String s : riddles) {
            for (String library : libraries) {
                if (isMatch(s, library)) {
                    sb.append(library).append(",");
                    break;
                }
            }
        }
        return sb.length() == 0 ? "not found" : sb.substring(0, sb.length() - 1);
    }

    public boolean isMatch(String riddle, String library) {
        int[] chars = new int[26];
        for (int i = 0; i < riddle.length(); i++) {
            chars[riddle.charAt(i) - 'a']++;
        }
        for (int i = 0; i < library.length(); i++) {
            chars[library.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] < 0 && !riddle.contains(String.valueOf((char) (i + 'a')))) {
                return false;
            }
            if (chars[i] > 0 && !library.contains(String.valueOf((char) (i + 'a')))) {
                return false;
            }
        }
        return true;
    }

    public int[] board(int n, int m, int[] a) {
        int len = a.length;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int j : a) {
            queue.add(j);
        }
        while (n != 0) {
            Integer min = queue.poll();
            min += m;
            queue.add(min);
            n--;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = queue.peek();
        }
        return ans;
    }

    public String lcs(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        String ans = "";
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = dp[i][j] > ans.length() ? text1.substring(i - dp[i][j], i) : ans;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return ans;
    }

    public int not101(int l, int r) {
        return count(r) - count(l - 1);
    }


    static int count(int x) {
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 1] - dp[i - 2];
        }
        int preOfPre = 0;
        int pre = 0;
        int count = 0;
        for (int i = 29; i >= 0; i--) {
            int mask = 1 << i;
            // 判断x的第i为是否为1
            if ((x & mask) != 0) {
                // 为1
                x -= mask;
                if (pre == 1) {
                    count += i == 0 ? 1 : dp[i - 1];
                } else {
                    count += dp[i];
                }
                if (preOfPre == 1 && pre == 0) {
                    break;
                }
                preOfPre = pre;
                pre = 1;
            } else {
                preOfPre = pre;
                pre = 0;
            }
            if (i == 0) {
                count += 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Huawei20230411 huawei20230411 = new Huawei20230411();
        System.out.println(huawei20230411.not101(1, 1000));
//        System.out.println(count(1000));
    }
}
