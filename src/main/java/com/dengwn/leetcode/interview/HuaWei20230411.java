package com.dengwn.leetcode.interview;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-04-12
 *
 */
public class HuaWei20230411 {
    public String charades(String enigma, String library) {
        String[] enigmas = enigma.split(",");
        String[] libraries = library.split(",");
        HashMap<String, String> dictionary = new HashMap<>();
        // 构建字典
        for (String s : libraries) {
            dictionary.put(deduplication(s), s);
        }
        StringBuilder ans = new StringBuilder();
        for (String s : enigmas) {
            String deduplication = deduplication(s);
            String findResult = dictionary.get(deduplication);
            if (findResult != null) {
                ans.append(findResult).append(",");
            }
        }
        return ans.length() == 0 ? "not found" : ans.substring(0, ans.length() - 1);
    }

    //去重
    public String deduplication(String str) {
        int[] chars = new int[26];
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (chars[i] > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

    public int board(int n, int m, int[] a) {
        // 数组第一位表示木板的长度，第二位表示这个长度的木板有多少
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(a[i], 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        while (m > 0) {
            int[] min = queue.poll();
            if (!queue.isEmpty()) {
                int[] second = queue.poll();
                int add = min[1] * (second[0] - min[0]);
                if (add <= m) {
                    m -= add;
                    queue.add(new int[]{second[0], min[1] + second[1]});
                } else {
                    queue.add(new int[]{second[0], second[1]});
                    queue.add(new int[]{min[0] + m / min[1], min[1]});
                    m -= m / min[1] * min[1];
                    break;
                }
            } else {
                break;
            }
        }
        int[] min = queue.peek();
        if (m > 0) {
            return m / min[1] + min[0];
        } else {
            return min[0];
        }
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
        HuaWei20230411 huawei20230411 = new HuaWei20230411();
        System.out.println(huawei20230411.charades("woo", "woooood,avcca"));

        System.out.println(huawei20230411.board(5, 3, new int[]{1, 5, 3, 5, 5}));

        System.out.println(huawei20230411.lcs("hello123world", "hello1233abc"));
    }

}
