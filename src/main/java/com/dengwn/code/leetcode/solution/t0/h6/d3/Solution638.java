package com.dengwn.code.leetcode.solution.t0.h6.d3;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/11/4
 **/
public class Solution638 {
    int n;
    List<Integer> price;
    List<List<Integer>> filterSpecial = new ArrayList<>();
    Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        this.n = price.size();
        // 过滤不需要计算的大礼包，只保留需要计算的大礼包
        for (List<Integer> sp : special) {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; ++i) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }
        return dfs(needs);
    }

    public int dfs(List<Integer> needs) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int minPrice = 0;
        for (int i = 0; i < n; ++i) {
            // 不购买任何大礼包，原价购买购物清单中的所有物品
            minPrice += needs.get(i) * price.get(i);
        }
        for (List<Integer> curSpecial : filterSpecial) {
            int specialPrice = curSpecial.get(n);
            List<Integer> nxtNeeds = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (curSpecial.get(i) > needs.get(i)) {
                    // 不能购买超出购物清单指定数量的物品
                    break;
                }
                nxtNeeds.add(needs.get(i) - curSpecial.get(i));
            }
            if (nxtNeeds.size() == n) {
                // 大礼包可以购买
                minPrice = Math.min(minPrice, dfs(nxtNeeds) + specialPrice);
            }
        }
        memo.put(needs, minPrice);
        return minPrice;
    }

    public static void main(String[] args) {
        Solution638 solution638 = new Solution638();
        List<Integer> price = Arrays.asList(9);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(1, 10), Arrays.asList(2, 2));
        List<Integer> needs = Arrays.asList(3);
        System.out.println(solution638.shoppingOffers(price, special, needs));
    }

}
