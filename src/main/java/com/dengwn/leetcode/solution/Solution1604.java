package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-02-07
 **/
public class Solution1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            map.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            map.get(name).add(hour * 60 + minute);
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if(value.size() < 3){
                continue;
            }
            Collections.sort(value);
            Integer first = value.get(0);
            Integer second = value.get(1);

            for (int i = 2; i < value.size(); i++) {
                Integer cur = value.get(i);
                if(cur - first <= 60){
                    ans.add(entry.getKey());
                    break;
                }else {
                    first = second;
                    second = cur;
                }
            }
        }
        ans.sort(String::compareTo);
        return ans;
    }

    public static void main(String[] args) {
        Solution1604 solution1604 = new Solution1604();
        String[] keyName = {"leslie","leslie","leslie","clare","clare","clare","clare"};
        String[] keyTime = {"13:00","13:20","14:00","18:00","18:51","19:30","19:49"};
        System.out.println(solution1604.alertNames(keyName,keyTime));
    }
}
