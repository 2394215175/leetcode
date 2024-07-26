package com.dengwn.leetcode.weeklyComp.h4.d1;

import com.dengwn.leetcode.solution.t0.h8.d7.help876.ListNode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author dengwenning
 * @since 2024/7/14
 **/
public class WeeklyComp406 {

    public String getSmallestString(String s) {
        char[] array = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1] && array[i] % 2 == array[i + 1] % 2) {
                char temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                break;
            }
        }
        return new String(array);
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode dummy = new ListNode(0, head);
        ListNode ans = dummy;
        while (dummy != null && dummy.next != null) {
            while (dummy.next != null && set.contains(dummy.next.val)) {
                dummy.next = dummy.next.next;
            }
            dummy = dummy.next;
        }
        return ans.next;
    }

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int x = 1;
        int y = 1;
        long ans = 0;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        while (x < n || y < m) {
            long yu = y <= m - 1 ? horizontalCut[m - 1 - y] : 0;
            long xu = x <= n - 1 ? verticalCut[n - 1 - x] : 0;
            // 那个大先切哪个
            if (xu >= yu) {
                ans += xu * y;
                x++;
            } else {
                ans += yu * x;
                y++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp406 weeklyComp406 = new WeeklyComp406();

//        System.out.println(weeklyComp406.getSmallestString("45320"));

//        int[] nums = {9, 2, 5};
//        ListNode head = new ListNode(2, new ListNode(10, new ListNode(9)));
//        System.out.println(weeklyComp406.modifiedList(nums, head));

        int m = 3, n = 2;
        int[] horizontalCut = {1, 3}, verticalCut = {5};
        System.out.println(weeklyComp406.minimumCost(m, n, horizontalCut, verticalCut));

    }
}
