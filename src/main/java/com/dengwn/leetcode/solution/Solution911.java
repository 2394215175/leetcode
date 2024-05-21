package com.dengwn.leetcode.solution;


import java.util.*;

/**
 * @author dengwenning
 * @since 2024/4/30
 **/
public class Solution911 {
    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));

    }
}

class TopVotedCandidate {

    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> pre;
    int[] table;
    int maxPerson;
    int max;

    public TopVotedCandidate(int[] persons, int[] times) {
        map = new HashMap<>();
        pre = new HashMap<>();
        table = times;
        maxPerson = 0;
        max = 0;
        int n = persons.length;
        for (int i = 0; i < n; i++) {
            Integer size = pre.getOrDefault(persons[i], 0);
            pre.put(persons[i], size + 1);
            if (size + 1 >= max) {
                maxPerson = persons[i];
                max = size + 1;
            }
            map.put(times[i], maxPerson);
        }
    }

    public int q(int t) {
        return map.get(table[search(t)]);
    }

    private int search(int target) {
        int left = 0;
        int right = table.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (table[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
