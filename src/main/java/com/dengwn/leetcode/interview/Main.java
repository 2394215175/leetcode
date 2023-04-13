package com.dengwn.leetcode.interview;

import lombok.val;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-04-12
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String hex = in.next();
            if (!hex.startsWith("0x")) {
                System.out.println("用例错误");
            }
            char[] chars = hex.toCharArray();
            int ans = 0;
            for (int i = 2; i < chars.length; i++) {
                ans *= 16;
                ans += chars[i] > '9' ? chars[i] - 'A' + 10 : chars[i] - '0';
            }
            System.out.println(ans);
        }
    }
}
