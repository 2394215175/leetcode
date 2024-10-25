package com.dengwn.code.leetcode.solution.t0.h7;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2024-03-26
 **/
public class Solution752 {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        if (dead.contains("0000")){
            return -1;
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int k = queue.size();
            for (int i = k; i > 0; i--) {
                String cur = queue.poll();
                if (target.equals(cur)) {
                    return step;
                }
                List<String> next = getNext(cur);
                for (String nt : next) {
                    if (!visited.contains(nt) && !dead.contains(nt)) {
                        visited.add(nt);
                        queue.offer(nt);
                    }
                }
            }

            step++;
        }
        return -1;
    }

    public char numAdd(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }


    public char numDiff(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public List<String> getNext(String cur) {
        List<String> ans = new ArrayList<>();
        char[] array = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
            char x = array[i];
            array[i] = numAdd(x);
            ans.add(new String(array));
            array[i] = numDiff(x);
            ans.add(new String(array));
            array[i] = x;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution752 solution752 = new Solution752();
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(solution752.openLock(deadends, target));
    }

}
