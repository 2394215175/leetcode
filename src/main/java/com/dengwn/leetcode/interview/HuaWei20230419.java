package com.dengwn.leetcode.interview;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-04-19
 **/
public class HuaWei20230419 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            String str1 = in.next();
//            String str2 = in.next();
//            System.out.println(encodeString(str1,str2));
//        }

        System.out.println(third("MMM"));
    }

    public static String encodeString(String str1, String str2) {
        Map<String, String> map = new HashMap<>();
        char[] chars1 = str1.toCharArray();
        int pre = 0;
        boolean isStart = false;
        for (int i = 0; i < chars1.length; i++) {
            if (isOther(chars1[i])) {
                chars1[i] = '0';
            }
        }
        for (int i = 0; i < str1.length(); i++) {
            if (!isOther(chars1[i]) && !isStart) {
                pre = i;
                isStart = true;
            } else if (!isOther(chars1[i])) {
                continue;
            } else {
                String s = str1.substring(pre, i);
                if (!"".equals(s)) {
                    map.put(dupl(s), s);
                }
                pre = i + 1;
                isStart = false;
            }
        }
        String s = str1.substring(pre);
        if (!"".equals(s)) {
            map.put(dupl(s), s);
        }

        int length = dupl(str2).length();
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> o1.length() == o2.length() ? o2.compareTo(o1) : o2.length() - o1.length());
        String ans = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.length() <= length) {
                if (key.length() > ans.length() || (key.length() == ans.length() && key.compareTo(ans) >= 0)) {
                    ans = key;
                }
            }
        }
        return map.get(ans);
    }

    public static boolean isOther(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f');
    }

    public static String dupl(String str) {
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            if (!set.contains(c)) {
                set.add(c);
                ans.append(c);
            }
        }
        return ans.toString();
    }


    public static void second(String s, int n) {
        String[][] board = new String[n][1001];
        int row = 0;
        int col = 0;
        for (int i = 0; i < s.length(); i++) {
            board[row][col] = s.substring(i, i + 1);
            if (col % 2 == 0) {
                row++;
            } else {
                row--;
            }
            if (row == n) {
                row--;
                col++;
            }
            if (row == -1) {
                row++;
                col++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1001; j++) {
                if (board[i][j] == null) {
                    System.out.println(builder.toString());
                    builder = new StringBuilder();
                    break;
                } else {
                    builder.append(board[i][j]);
                }
            }
        }
    }

    public static int third(String s) {
        int n = s.length();
        if (n == 1 && s.equals("M")) {
            return -1;
        }
        int[][] dp = new int[n][2];
        char[] chars = s.toCharArray();
        // 第一位表示数量
        dp[0][0] = 0;
        // 第二位表示是否已有供电箱
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i] == 'M') {
                // 如果前一个位置已经有供电箱
                if (dp[i - 1][1] == 1) {
                    dp[i][0] = dp[i - 1][0];
                } else {
                    // 如果前一个位置有空位
                    if (chars[i - 1] == 'I') {
                        // 加1
                        dp[i][0] = dp[i - 1][0] + 1;
                        // 表示已有
                        dp[i - 1][1] = 1;
                    }
                }
            } else {
                // 如果当前位置是空的
                // 判断前一个位置是不是需要供电箱
                if (chars[i - 1] == 'M') {
                    // 前前位置已有
                    if (i - 2 >= 0 && dp[i - 2][1] == 1) {
                        // 当前位置不管
                        dp[i][0] = dp[i - 1][0];
                    } else {
                        dp[i][0] = dp[i - 1][0] + 1;
                        // 表示已有
                        dp[i][1] = 1;
                    }
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }
        if (s.contains("M") && dp[n - 1][0] == 0) {
            return -1;
        }
        return dp[n - 1][0];
    }
}
