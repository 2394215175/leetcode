package com.dengwn.code.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author dengwenning
 * @since 2025/1/16
 **/
public class Question3 {

    public static void main(String[] args) {
        Question3 question3 = new Question3();
        System.out.println(Arrays.toString(question3.allocateRedPacket(100, 10)));
    }

    public int[] allocateRedPacket(int totalAmount, int numPeople) {
        if (totalAmount < numPeople) {
            throw new IllegalArgumentException("总金额不足以分配给每个人至少1元");
        }
        if (numPeople < 4) {
            throw new IllegalArgumentException("必定有人抢到的金额超过总金额的30%");
        }

        // 每个人至少分到1元
        int minAmount = 1;
        int[] amounts = new int[numPeople];
        Arrays.fill(amounts, minAmount);

        // 剩余金额
        int remainingAmount = totalAmount - numPeople * minAmount;
        Random random = new Random();
        // 随机分配剩余金额
        for (int i = 0; i < numPeople; i++) {
            // 每个人最多不能超过总金额的30%
            int maxAllowed = Math.min(remainingAmount, (int) (totalAmount * 0.3) - minAmount);
            if (maxAllowed <= 0) {
                break;
            }

            // 随机分配金额
            int amount = random.nextInt(maxAllowed + 1);
            amounts[i] += amount;
            remainingAmount -= amount;
        }

        // 如果还有剩余金额，随机分配给某个人
        while (remainingAmount > 0) {
            int idx = random.nextInt(numPeople);
            int maxAllowed = (int) (totalAmount * 0.3) - amounts[idx];
            if (maxAllowed > 0) {
                int addAmount = Math.min(remainingAmount, maxAllowed);
                amounts[idx] += addAmount;
                remainingAmount -= addAmount;
            }
        }

        return amounts;
    }
}
