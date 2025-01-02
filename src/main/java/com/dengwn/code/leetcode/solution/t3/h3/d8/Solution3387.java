package com.dengwn.code.leetcode.solution.t3.h3.d8;

import javafx.util.Pair;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/12/17
 **/
public class Solution3387 {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        HashMap<String, List<Pair<String, Double>>> day1 = new HashMap<>();
        HashMap<String, List<Pair<String, Double>>> day2 = new HashMap<>();
        for (int i = 0; i < pairs1.size(); i++) {
            String startCurrency = pairs1.get(i).get(0);
            String targetCurrency = pairs1.get(i).get(1);
            List<Pair<String, Double>> list1 = day1.getOrDefault(startCurrency, new ArrayList<>());
            List<Pair<String, Double>> list2 = day1.getOrDefault(targetCurrency, new ArrayList<>());
            list1.add(new Pair<>(targetCurrency, rates1[i]));
            list2.add(new Pair<>(startCurrency, 1.0 / rates1[i]));
            day1.put(startCurrency, list1);
            day1.put(targetCurrency, list2);
        }
        for (int i = 0; i < pairs2.size(); i++) {
            String startCurrency = pairs2.get(i).get(0);
            String targetCurrency = pairs2.get(i).get(1);
            List<Pair<String, Double>> list1 = day2.getOrDefault(startCurrency, new ArrayList<>());
            List<Pair<String, Double>> list2 = day2.getOrDefault(targetCurrency, new ArrayList<>());
            list1.add(new Pair<>(targetCurrency, rates2[i]));
            list2.add(new Pair<>(startCurrency, 1.0 / rates2[i]));
            day2.put(startCurrency, list1);
            day2.put(targetCurrency, list2);
        }

        Map<String, Double> result = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(initialCurrency);
        result.put(initialCurrency, 1.0);
        while (!queue.isEmpty()) {
            String curCurrency = queue.poll();
            Double curSize = result.get(curCurrency);
            List<Pair<String, Double>> pairs = day1.get(curCurrency);
            if (pairs != null) {
                for (Pair<String, Double> pair : pairs) {
                    String nexCurrency = pair.getKey();
                    Double rate = pair.getValue();
                    if (curSize * rate > result.getOrDefault(nexCurrency, 0.0)) {
                        queue.add(nexCurrency);
                        result.put(nexCurrency, curSize * rate);
                    }
                }
            }
        }

        queue.addAll(result.keySet());
        while (!queue.isEmpty()) {
            String curCurrency = queue.poll();
            Double curSize = result.get(curCurrency);
            List<Pair<String, Double>> pairs = day2.get(curCurrency);
            if (pairs != null) {
                for (Pair<String, Double> pair : pairs) {
                    String nexCurrency = pair.getKey();
                    Double rate = pair.getValue();
                    if (curSize * rate > result.getOrDefault(nexCurrency, 0.0)) {
                        queue.add(nexCurrency);
                        result.put(nexCurrency, curSize * rate);
                    }
                }
            }
        }

        return result.get(initialCurrency);
    }

    public static void main(String[] args) {
        String initialCurrency = "ACB";
        List<List<String>> pairs1 = Arrays.asList(Arrays.asList("SFE", "Z"), Arrays.asList("ACB", "SFE"));
        double[] rates1 = {9.1, 2.4};
        List<List<String>> pairs2 = Arrays.asList(Arrays.asList("SFE", "Z"), Arrays.asList("ACB", "SFE"));
        double[] rates2 = {2.8, 5.0};

//        String initialCurrency = "EUR";
//        List<List<String>> pairs1 = Arrays.asList(Arrays.asList("EUR", "USD"), Arrays.asList("USD", "JPY"));
//        double[] rates1 = {2.0, 3.0};
//        List<List<String>> pairs2 = Arrays.asList(Arrays.asList("JPY", "USD"), Arrays.asList("USD", "CHF"), Arrays.asList("CHF", "EUR"));
//        double[] rates2 = {4.0, 5.0, 6.0};
        Solution3387 solution3387 = new Solution3387();
        System.out.println(solution3387.maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2));
    }
}
