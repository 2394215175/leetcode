package com.dengwn.code.leetcode.solution.t2.h0.d5;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/4
 **/
public class Solution2056 {

    // 每种棋子的移动方向
    private static final Map<String, int[][]> PIECE_DIRS = new HashMap<>();

    public int countCombinations(String[] pieces, int[][] positions) {
        PIECE_DIRS.put("rook", new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}});
        PIECE_DIRS.put("bishop", new int[][]{{1, 1}, {-1, 1}, {-1, -1}, {1, -1}});
        PIECE_DIRS.put("queen", new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}});

        int n = pieces.length;


        return 0;
    }

}
