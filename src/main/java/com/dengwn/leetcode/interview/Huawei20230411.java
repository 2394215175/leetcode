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
        return count(r) - count(l-1);
    }


    static int count(int x) {
        if (x == 0) {
            return 0;
        }
        int[] bits = new int[Integer.toBinaryString(x).length()];
        for (int i = bits.length - 1; i >= 0; i--) {
            bits[i] = (x & 1 << i) != 0 ? 1 : 0;
        }
        int[][][] dp = new int[x][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = 0;
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 0;
                    for (int u = 0; u < 2; u++) {
                        if (j == 0 || (j == 1 && u == 0)) {
                            dp[i][j][k] = dp[i][j][k] + dp[i - 1][u][k];
                        }
                    }
                }
            }
        }
        int ans = 0;
        boolean flag = true;
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] == 1) {
                if (flag) {
                    ans += dp[i][2][2];
                }
                flag = false;
            } else if (!flag) {
                ans += dp[i][2][0];
            }
        }
        return ans + dp[0][2][0];
    }

    static BigInteger count(BigInteger x) {
        if (x.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        int[] bits = new int[x.bitLength()];
        for (int i = bits.length - 1; i >= 0; i--) {
            bits[i] = x.testBit(i) ? 1 : 0;
        }
        BigInteger[][][] dp = new BigInteger[bits.length][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = BigInteger.ZERO;
            }
        }
        dp[0][0][0] = BigInteger.ONE;
        for (int i = 1; i < bits.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = BigInteger.ZERO;
                    for (int u = 0; u < 2; u++) {
                        if (j == 0 || (j == 1 && u == 0)) {
                            dp[i][j][k] = dp[i][j][k].add(dp[i - 1][u][k]);
                        }
                    }
                }
            }
        }
        BigInteger ans = BigInteger.ZERO;
        boolean flag = true;
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] == 1) {
                if (flag) {
                    ans = ans.add(dp[i][2][2]);
                }
                flag = false;
            } else if (!flag) {
                ans = ans.add(dp[i][2][0]);
            }
        }
        ans = ans.add(dp[0][2][0]);
        return ans;
    }

    public static void main(String[] args) {
        Huawei20230411 huawei20230411 = new Huawei20230411();
        System.out.println(huawei20230411.not101(1,1000));
        System.out.println(count(1000));
        BigInteger bigInteger = new BigInteger("1000");
        System.out.println(count(bigInteger));
    }
}
