package com.dengwn.code.leetcode.weeklyComp.h4.d3;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2025/2/5
 **/
public class WeeklyComp434 {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % 2 == 0 ? n - 1 : 0;
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] ans = new int[numberOfUsers];
        int[] life = new int[numberOfUsers];
        int cnt = 0;
        events.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.get(1));
            int t2 = Integer.parseInt(o2.get(1));
            return t1 == t2 ? o2.get(0).compareTo(o1.get(0)) : t1 - t2;
        });
        for (List<String> event : events) {
            String type = event.get(0);
            if ("MESSAGE".equals(type)) {
                String mentions = event.get(2);
                if ("ALL".equals(mentions)) {
                    cnt++;
                } else if ("HERE".equals(mentions)) {
                    String timestamp = event.get(1);
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (Integer.parseInt(timestamp) >= life[i]) {
                            ans[i]++;
                        }
                    }
                } else {
                    String[] split = mentions.split(" ");
                    for (String s : split) {
                        ans[Integer.parseInt(s.substring(2))]++;
                    }
                }
            } else if ("OFFLINE".equals(type)) {
                String timestamp = event.get(1);
                String id = event.get(2);
                life[Integer.parseInt(id)] = Integer.parseInt(timestamp) + 60;
            }
        }
        for (int i = 0; i < numberOfUsers; i++) {
            ans[i] += cnt;
        }
        return ans;
    }



    public static void main(String[] args) {
        WeeklyComp434 weeklyComp434 = new WeeklyComp434();

//        System.out.println(Arrays.toString(weeklyComp434.countMentions(15,
//                Arrays.asList(
//                        Arrays.asList("MESSAGE","174","HERE"),
//                        Arrays.asList("OFFLINE","426","0"),
//                        Arrays.asList("MESSAGE","98","ALL"),
//                        Arrays.asList("MESSAGE","383","ALL"),
//                        Arrays.asList("MESSAGE","178","id13 id1 id6 id0 id8 id6 id0"),
//                        Arrays.asList("OFFLINE","474","10"),
//                        Arrays.asList("MESSAGE","190","ALL"),
//                        Arrays.asList("MESSAGE","190","HERE"),
//                        Arrays.asList("MESSAGE","366","ALL"),
//                        Arrays.asList("OFFLINE","113","4"),
//                        Arrays.asList("MESSAGE","130","HERE"),
//                        Arrays.asList("OFFLINE","299","10"),
//                        Arrays.asList("OFFLINE","352","8"),
//                        Arrays.asList("MESSAGE","167","id12 id13 id2 id10")
//                        )))
//        );
    }
}
