package com.dengwn.code.leetcode;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2025/1/15
 **/
public class Question1 {

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        System.out.println(question1.countWords("Welcome4(ToAlibaba(To3)2)2"));
    }

    public String countWords(String input) {
        // 去除括号
        Stack<String> stack = removeBrackets(input);
        // 计算每个单词次数
        TreeMap<String, String> ans = calcCount(stack);

        StringBuilder result = new StringBuilder();
        while (!ans.isEmpty()) {
            Map.Entry<String, String> entry = ans.pollFirstEntry();
            result.append(entry.getKey());
            if (!"1".equals(entry.getValue())) {
                result.append(entry.getValue());
            }
        }
        return result.toString();
    }

    private TreeMap<String, String> calcCount(Stack<String> stack) {
        TreeMap<String, String> ans = new TreeMap<>();
        while (!stack.isEmpty()) {
            String curWord = stack.pop();
            String[] arr = curWord.split("_");
            // 找第一个单词里的数字
            int firstNum = getFirstNum(arr[0]);
            String word;
            String times = "1";
            if (firstNum == -1) {
                // 没有数字
                word = arr[0];
            } else {
                word = arr[0].substring(0, firstNum);
                times = arr[0].substring(firstNum);
            }
            for (int i = 1; i < arr.length; i++) {
                times = multiply(times, arr[i]);
            }
            ans.put(word, add(ans.getOrDefault(word, "0"), times));
        }
        return ans;
    }

    private int getFirstNum(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            // 如果是数字
            if (Character.isDigit(str.charAt(i))) {
                return i;
            }
        }
        // 没找到返回-1
        return -1;
    }

    private Stack<String> removeBrackets(String input) {
        int n = input.length();
        char[] inputArray = input.toCharArray();
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            char currentChar = inputArray[i];

            if (Character.isUpperCase(currentChar)) {
                // 是一个大写字母
                StringBuilder word = new StringBuilder();
                word.append(currentChar);
                i++;
                // 继续添加小写字母和数字
                while (i < n && (Character.isLowerCase(inputArray[i]) || Character.isDigit(inputArray[i]))) {
                    word.append(inputArray[i]);
                    i++;
                }
                // 加入一个单词
                stack.add(word.toString());
            } else if (currentChar == '(') {
                i++;
                // 加入一个左扩号
                stack.add("(");
            } else if (currentChar == ')' || i == n - 1) {
                i++;
                StringBuilder num = new StringBuilder();
                while (i < n && Character.isDigit(inputArray[i])) {
                    num.append(inputArray[i]);
                    i++;
                }
                String numStr = num.length() == 0 ? "1" : num.toString();
                List<String> list = new ArrayList<>();
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    list.add(stack.pop() + "_" + numStr);
                }
                if (!stack.isEmpty()) {
                    // 移除最上面的括号
                    stack.pop();
                }
                stack.addAll(list);
            } else {
                i++;
            }
        }
        return stack;
    }

    private String multiply(String num1, String num2) {
        // 如果其中一个数为 "0"，直接返回 "0"
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        // 从右到左遍历 num1 和 num2
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 计算当前位的乘积
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 将乘积加到正确的位置
                int sum = product + result[i + j + 1];
                // 当前位的值
                result[i + j + 1] = sum % 10;
                // 进位
                result[i + j] += sum / 10;
            }
        }

        // 将结果数组转换为字符串
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // 跳过前导零
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    private String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        // 进位
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        // 从右到左逐位相加
        while (i >= 0 || j >= 0 || carry > 0) {
            // 获取当前位的值
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            // 计算当前位的和
            int sum = digit1 + digit2 + carry;
            // 计算进位
            carry = sum / 10;
            // 将当前位的值添加到结果中
            sb.append(sum % 10);

            // 移动索引
            i--;
            j--;
        }

        // 反转结果并去除前导零
        String sumStr = sb.reverse().toString();
        return sumStr.isEmpty() ? "0" : sumStr;
    }

}
