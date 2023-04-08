package com.dengwn.leetcode.solution;

import org.springframework.util.StopWatch;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-03-07
 **/
public class Solution1096 {
    public List<String> braceExpansionII(String expression) {
        return null;
    }

    // 测试代码
    public static String genRandomCustomoCodes(String preFix) {
        String yearLast = new SimpleDateFormat("yy", Locale.CHINESE).format(new Date());
        return preFix + yearLast + (int) ((Math.random() * 9 + 1) * 10000000);
    }

    public static void main(String[] args) {
        int size = 0;
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < 1000; i++) {
            stopWatch.start(i + "");
            Set<String> set = new HashSet<>();
            for (int j = 0; j < 1000; j++) {
                set.add(genRandomCustomoCodes("30"));
            }
            if(set.size() != 1000){
                size++;
            }
            stopWatch.stop();
        }
        System.out.println(stopWatch.prettyPrint());
        System.out.println(size);
    }


}
