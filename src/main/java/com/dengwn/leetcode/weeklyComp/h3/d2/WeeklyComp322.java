package com.dengwn.leetcode.weeklyComp.h3.d2;

import java.util.*;

/**
 * @author dengwn
 * @date: 2022-12-04
 */
public class WeeklyComp322 {
    public boolean isCircularSentence(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return sentence.charAt(sentence.length() - 1) == sentence.charAt(0);
    }

    public long dividePlayers(int[] skill) {
        int length = skill.length;
        Arrays.sort(skill);
        int sum = Arrays.stream(skill).sum();
        double ave = sum * 1.0 / length;
        long res = 0;
        for (int i = 0; i < length / 2; i++) {
            if (skill[i] + skill[length - 1 - i] != ave * 2) {
                return -1;
            }
            res += (long) skill[i] * skill[length - 1 - i];
        }
        return res;
    }

    public int minScore(int n, int[][] roads) {
        int res = Integer.MAX_VALUE;

        HashMap<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            Map<Integer, Integer> indexMap = map.getOrDefault(roads[i][0], new HashMap<>());
            indexMap.put(roads[i][1], roads[i][2]);
            map.put(roads[i][0], indexMap);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Set<Integer>> queue = new LinkedList<>();
        HashSet<Integer> start = new HashSet<>();
        start.add(1);
        queue.add(start);

        while (!queue.isEmpty()) {
            Set<Integer> cur = queue.poll();
            Set<Integer> next = new HashSet<>();
            for (Integer integer : cur) {
                if( visited.contains(integer)){
                    continue;
                }
                Map<Integer, Integer> curMap = map.get(integer);
                if(curMap == null){
                    continue;
                }

                Set<Map.Entry<Integer, Integer>> entrySet = curMap.entrySet();
                for (Map.Entry<Integer, Integer> entry : entrySet) {
                    next.add(entry.getKey());
                    Integer value = entry.getValue();
                    if (value < res) {
                        res = value;
                    }
                }
            }
            visited.addAll(cur);
            if(!next.isEmpty()){
                queue.add(next);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        WeeklyComp322 weeklyComp323 = new WeeklyComp322();

//        boolean a = weeklyComp20221204.isCircularSentence("Leetcode is cool");
//        System.out.println(a);
//
//        int[] skill = {1, 1, 2, 3};
//        long b = weeklyComp20221204.dividePlayers(skill);
//        System.out.println(b);

        int n = 14;
        int[][] roads = {{12,7,2151},{7,2,7116},{11,14,8450},{11,2,9954},{1,11,3307},{10,7,3561},{10,1,4986},{11,7,7674},{14,2,1764},{11,12,6608},{14,7,1070},{9,8,2287},{14,12,6559},{1,2,1450},{2,12,9165}};
        int c = weeklyComp323.minScore(n, roads);
        System.out.println(c);
    }
}

//14
//        [[12,7,2151],[7,2,7116],[11,14,8450],[11,2,9954],[1,11,3307],[10,7,3561],[10,1,4986],[11,7,7674],[14,2,1764],[11,12,6608],[14,7,1070],[9,8,2287],[14,12,6559],[1,2,1450],[2,12,9165]]
