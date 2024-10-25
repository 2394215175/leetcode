package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d4;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.apache.tomcat.util.net.jsse.JSSEUtil;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/10/16
 **/
public class DoubleWeeklyComp141 {

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        int i = 0;
        for (Integer num : nums) {
            char[] array = Integer.toBinaryString(num).toCharArray();
            StringBuilder sb = new StringBuilder();
            int k = array.length - 1;
            if (array[k] == '0') {
                res[i] = -1;
                i++;
                continue;
            }
            while (k >= 0) {
                if (array[k] == '1') {
                    if (k - 1 < 0 || array[k - 1] == '0') {
                        sb.append('0');
                        k--;
                        break;
                    } else {
                        sb.append('1');
                    }
                }
                k--;
            }
            while (k >= 0) {
                sb.append(array[k]);
                k--;
            }
            res[i] = Integer.parseInt(sb.reverse().toString(), 2);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp141 doubleWeeklyComp141 = new DoubleWeeklyComp141();

        List<Integer> list = Arrays.asList(2, 3, 5, 7);
        int[] res = doubleWeeklyComp141.minBitwiseArray(list);
        System.out.println(Arrays.toString(res));
    }
}
