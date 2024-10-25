package com.dengwn.code.leetcode.solution.t1.h1.d4;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/4/26
 **/
public class Solution1146 {

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0, 15);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.get(0, 2);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.get(0, 0);

    }
}

class SnapshotArray {

    private int curSnapId;
    private HashMap<Integer, List<int[]>> history;

    public SnapshotArray(int length) {
        this.curSnapId = 0;
        this.history = new HashMap<>(length);
    }

    public void set(int index, int val) {
        history.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{curSnapId, val});
    }

    public int snap() {
        return curSnapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> list = history.get(index);
        if (list == null) {
            return 0;
        }
        int search = search(list, snap_id);
        return search < 0 ? 0 : list.get(search)[1];
    }

    // 返回最大的下标 i，满足 h[i][0] <= x
    // 如果不存在则返回 -1
    private int search(List<int[]> h, int x) {
        // 开区间 (left, right)
        int left = -1;
        int right = h.size();
        // 区间不为空
        while (left + 1 < right) {
            // 循环不变量：
            // h[left][0] <= x
            // h[right][1] > x
            int mid = left + (right - left) / 2;
            if (h.get(mid)[0] <= x) {
                // 区间缩小为 (mid, right)
                left = mid;
            } else {
                // 区间缩小为 (left, mid)
                right = mid;
            }
        }
        // 根据循环不变量，此时 h[left][0] <= x 且 h[left+1][0] = h[right][0] > x
        // 所以 left 是最大的满足 h[left][0] <= x 的下标
        // 如果不存在，则 left 为其初始值 -1
        return left;
    }

}
