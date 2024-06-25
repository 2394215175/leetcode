package com.dengwn.leetcode.solution.t1.h7.d9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-02-09
 **/
public class Solution1797 {
}

class AuthenticationManager {
    int time;
    Map<String, Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        time = timeToLive;
        tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + time);
    }

    public void renew(String tokenId, int currentTime) {
        Integer token = tokens.get(tokenId);
        if (token == null || token <= currentTime) {
            return;
        }
        tokens.put(tokenId, currentTime + time);
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        for (Map.Entry<String, Integer> entry : tokens.entrySet()) {
            if(entry.getValue() > currentTime){
                ans++;
            }
        }
        return ans;
    }
}
