package com.dengwn.leetcode.doubleWeeklyComp;

import javafx.util.Pair;

import java.util.*;

/**
 * @author dengwn
 * @date: 2022-12-24
 */
public class DoubleWeeklyComp94 {
    public int captureForts(int[] forts) {
        int ans = 0;
        int length = forts.length;
        for (int k = 0; k < length; k++) {
            if (forts[k] == 1) {
                int num = 0;
                int left = k;
                int right = k;
                while (left > 0) {
                    left--;
                    if (forts[left] == 0) {
                        num++;
                    } else if (forts[left] == 1) {
                        break;
                    } else {
                        ans = Math.max(ans, num);
                        break;
                    }
                }

                num = 0;
                while (right < length - 1) {
                    right++;
                    if (forts[right] == 0) {
                        num++;
                    } else if (forts[right] == 1) {
                        break;
                    } else {
                        ans = Math.max(ans, num);
                        break;
                    }
                }
            }
        }
        return ans;

    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Pair<Integer, Integer>> targets = new LinkedList<>();

        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            int target = 0;
            for (int j = 0; j < split.length; j++) {
                if (positive.contains(split[j])) {
                    target += 3;
                }
                if (negative.contains(split[j])) {
                    target -= 1;
                }
            }
            Pair<Integer, Integer> pair = new Pair<>(target, student_id[i]);
            targets.add(pair);
        }
        targets.sort((o1, o2) -> o1.getKey().equals(o2.getKey()) ? o1.getValue() - o2.getValue(): o2.getKey() - o1.getKey());


        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.add(targets.get(i).getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp94 doubleWeeklyComp94 = new DoubleWeeklyComp94();
        int[] forts = {-1, -1, 0, 1, 0, 0, 1, -1, 1, 0};
        System.out.println(doubleWeeklyComp94.captureForts(forts));

        String[] positive_feedback = {"smart","brilliant","studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is not studious","the student is smart"};
        int[] student_id = {1, 2};
        int k = 2;
        System.out.println(doubleWeeklyComp94.topStudents(positive_feedback, negative_feedback, report, student_id, k));
    }

}
