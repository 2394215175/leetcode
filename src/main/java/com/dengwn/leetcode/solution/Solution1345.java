package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2022-11-24
 **/
public class Solution1345 {
    public int minJumps(int[] arr) {
        return bfs(arr);
    }

    public int bfs(int[] arr) {
        int arrLen = arr.length;
        // key - arr[i], val - i
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arrLen; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new LinkedList<>());
            list.add(i);
            map.put(arr[i], list);
        }

        int count = 0;

        Queue<Set<Integer>> queue = new LinkedList<>();
        Set<Integer> start = new HashSet<>();
        start.add(0);
        queue.add(start);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Set<Integer> curs = queue.poll();
            Set<Integer> next = new HashSet<>();
            visited.addAll(curs);

            // 判断当前下标的前一个元素
            for (Integer cur : curs) {
                int left = cur - 1;
                if (left >= 0 && !visited.contains(left)) {
                    // 左边不可能是最后一个元素
                    next.add(left);
                }
                // 判断当前下标的后一个元素
                int right = cur + 1;
                if (right < arrLen && !visited.contains(right)) {
                    if (right == arrLen - 1) {
                        return count + 1;
                    }
                    next.add(right);
                }

                // 判断当前值一样的元素
                List<Integer> curVal = map.get(arr[cur]);
                if (curVal != null) {
                    // 判断最后一个是否结束
                    if (curVal.get(curVal.size() - 1) == arrLen - 1) {
                        return count + 1;
                    } else {
                        // 移除当前的并将剩下的全部加到下次
                        curVal.remove(cur);
                        next.addAll(curVal);
                    }
                    map.remove(arr[cur]);
                }
            }
            queue.add(next);
            count++;
        }
        return 0;
    }
}
