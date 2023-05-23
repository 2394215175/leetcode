package com.dengwn.leetcode;

import java.util.*;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * @author dengwn
 * @date: 2023-04-22
 */
public class LeetCodeSpring {
    public int[] supplyWagon(int[] supplies) {
        int n = supplies.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < n - 1 - i; j++) {
                int merge = supplies[j] + supplies[j + 1];
                if (merge < min) {
                    min = merge;
                    minIndex = j;
                }
            }
            supplies[minIndex] = min;
            if (n - 1 - i - (minIndex + 1) >= 0) {
                System.arraycopy(supplies, minIndex + 1 + 1, supplies, minIndex + 1, n - 1 - i - (minIndex + 1));
            }
        }

        return Arrays.copyOf(supplies, n / 2);
    }

    public int adventureCamp(String[] expeditions) {
        int n = expeditions.length;
        String[] start = expeditions[0].split("->");
        HashSet<String> set = new HashSet<>();
        set.add("");
        set.addAll(Arrays.asList(start));

        int ans = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int temp = 0;
            String[] split = expeditions[i].split("->");
            HashSet<String> strings = new HashSet<>(Arrays.asList(split));
            for (String s : strings) {
                if (set.add(s)) {
                    temp++;
                }
            }
            if (temp > max) {
                max = temp;
                ans = i;
            }
        }
        return ans == 0 ? -1 : ans;
    }


    public int fieldOfGreatestBlessing(int[][] forceField) {
        ArrayList<long[]> list = new ArrayList<>();
        for (int[] i : forceField) {
            list.add(new long[]{i[0] * 2L - i[2], 1, i[1] * 2L - i[2], i[1] * 2L + i[2]});
            list.add(new long[]{i[0] * 2L + i[2], -1, i[1] * 2L - i[2], i[1] * 2L + i[2]});
        }
        list.sort((o, p) -> o[0] == p[0] ? Long.compare(p[1], o[1]) : Long.compare(o[0], p[0]));
        int max = 0;
        for (int[] i : forceField) {
            for (int j = 0, count = 0; j < list.size(); j++) {
                max = Math.max(max, count += list.get(j)[2] > i[1] * 2L - i[2] || list.get(j)[3] < i[1] * 2L - i[2] ? 0
                        : list.get(j)[1]);
            }
            for (int j = 0, count = 0; j < list.size(); j++) {
                max = Math.max(max, count += list.get(j)[2] > i[1] * 2L + i[2] || list.get(j)[3] < i[1] * 2L + i[2] ? 0
                        : list.get(j)[1]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCodeSpring leetCodeSpring = new LeetCodeSpring();

//        int[] supplies = {1,3,1,5};
//        System.out.println(Arrays.toString(leetCodeSwing.supplyWagon(supplies)));

//        String[] expeditions = {"xO->xO->xO", "xO->BKbWDH", "xO->BKbWDH", "BKbWDH->mWXW", "LSAYWW->LSAYWW", "oAibBvPdJ", "LSAYWW->u", "LSAYWW->LSAYWW"};
//        System.out.println(leetCodeSwing.adventureCamp(expeditions));

//        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.containsKey()

//        Object a = 10;
//        int h;
//        int hash = (h = a.hashCode()) ^ (h >>> 16);
//        System.out.println(hash);


        int n = 3 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int a = (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
        System.out.println(a);
//        HashMap<String,String> map = new HashMap<>(2);
//        System.out.println(1);
//        System.out.println("-------");
//        String put1 = map.put("1", "!");
//        String put2 = map.put("1", "2");
//        map.put("12","1121");
//        map.put("444","1312");
//
//        System.out.println(put1);
//        System.out.println(put2);
//
//        int newThr = 0;
//        int newCap = 1;
//        float ft = (float)newCap * 0.75f;
//        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
//                (int)ft : Integer.MAX_VALUE);
//        System.out.println(newThr);

        System.out.println(1<<30);
        System.out.println(Math.pow(2,30));
    }
}
