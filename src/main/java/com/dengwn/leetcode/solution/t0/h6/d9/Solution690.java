package com.dengwn.leetcode.solution.t0.h6.d9;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *
 * @author dengwenning
 * @since 2024/8/29
 **/
public class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        Map<Integer, Employee> map = new HashMap<>(employees.size());
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            ans += employee.importance;
            if (employee.subordinates == null) {
                continue;
            }
            for (Integer subordinate : employee.subordinates) {
                queue.add(map.get(subordinate));
            }
        }
        return ans;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
