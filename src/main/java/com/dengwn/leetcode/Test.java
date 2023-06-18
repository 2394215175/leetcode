package com.dengwn.leetcode;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author: dengwn
 * @date: 2023-06-12
 **/
public class Test {

    private int[] grad = {0, 5, 20, 50, 100, 500, 1000, 2000};

    private HashMap<Integer, int[]> table = new HashMap<>();

    public void init() {
        table.put(1, new int[]{0, 30});
        table.put(2, new int[]{150, 15});
        table.put(3, new int[]{375, 10});
        table.put(4, new int[]{825, 9});
        table.put(5, new int[]{1125, 8});
        table.put(6, new int[]{4325, 7});
        table.put(7, new int[]{7825, 6});
    }

    public int count(int orderSize) throws IllegalAccessException {
        int len = grad.length;
        init();
        if (orderSize > grad[len - 1] || orderSize <= grad[0]) {
            throw new IllegalAccessException("订单数量错误");
        }
        for (int i = len - 2; i >= 0; i--) {
            if (orderSize > grad[i]) {
                return table.get(i)[0] + (orderSize - grad[i]) * table.get(i)[1];
            }
        }
        throw new IllegalAccessException("订单数量错误");
    }

    public static void main(String[] args) {
        System.out.println(5 * 30 + 15 * 15);
    }
}
