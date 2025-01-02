package com.dengwn.code.leetcode.solution.t0.h3.d8;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/12/26
 **/
public class Solution380 {
}

class RandomizedSet {

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> indexes;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        indexes = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        }
        int size = nums.size();
        nums.add(val);
        indexes.put(val, size);
        return true;
    }

    public boolean remove(int val) {
        if (!indexes.containsKey(val)) {
            return false;
        }
        int index = indexes.get(val);
        int lastIndex = nums.size();
        int lastVal = nums.get(lastIndex - 1);
        nums.set(index, lastVal);
        nums.remove(lastIndex - 1);
        indexes.put(lastVal, index);
        indexes.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }
}

