//给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。 
//
// 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ： 
//
// 
// i + 1 需满足：i + 1 < arr.length 
// i - 1 需满足：i - 1 >= 0 
// j 需满足：arr[i] == arr[j] 且 i != j 
// 
//
// 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。 
//
// 注意：任何时候你都不能跳到数组外面。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
//输出：3
//解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
// 
//
// 示例 2： 
//
// 
//输入：arr = [7]
//输出：0
//解释：一开始就在最后一个元素处，所以你不需要跳跃。
// 
//
// 示例 3： 
//
// 
//输入：arr = [7,6,9,6,9,6,9,7]
//输出：1
//解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr.length <= 5 * 10⁴ 
// -10⁸ <= arr[i] <= 10⁸ 
// 
//
// Related Topics 广度优先搜索 数组 哈希表 👍 220 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minJumps(int[] arr) {
        int arrLen = arr.length;
        if(arrLen == 1){
            return 0;
        }
        // key - arr[i], val - i
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arrLen; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new LinkedList<>());
            list.add(i);
            map.put(arr[i], list);
        }

        int count = 0;

        Queue<Set<Integer>> queue = new LinkedList<>();
        Set<Integer> start = new HashSet<>();
        start.add(0);
        queue.add(start);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Set<Integer> curs = queue.poll();
            Set<Integer> next = new HashSet<>();
            visited.addAll(curs);

            // 判断当前下标的前一个元素
            for (Integer cur : curs) {
                int left = cur - 1;
                if (left >= 0 && !visited.contains(left)) {
                    // 左边不可能是最后一个元素
                    next.add(left);
                }
                // 判断当前下标的后一个元素
                int right = cur + 1;
                if (right < arrLen && !visited.contains(right)) {
                    if (right == arrLen - 1) {
                        return count + 1;
                    }
                    next.add(right);
                }

                // 判断当前值一样的元素
                List<Integer> curVal = map.get(arr[cur]);
                if (curVal != null) {
                    // 判断最后一个是否结束
                    if (curVal.get(curVal.size() - 1) == arrLen - 1) {
                        return count + 1;
                    } else {
                        // 移除当前的并将剩下的全部加到下次
                        curVal.remove(cur);
                        next.addAll(curVal);
                    }
                    map.remove(arr[cur]);
                }
            }
            queue.add(next);
            count++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
