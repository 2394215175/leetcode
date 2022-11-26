//稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。 
//
// 示例1: 
//
//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ta"
// 输出：-1
// 说明: 不存在返回-1。
// 
//
// 示例2: 
//
//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], 
//s = "ball"
// 输出：4
// 
//
// 提示: 
//
// 
// words的长度在[1, 1000000]之间 
// 
//
// Related Topics 数组 字符串 二分查找 👍 75 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findString(String[] words, String s) {
        return binarySearch(0, words.length - 1, words, s);
    }

    public int binarySearch(int left, int right, String[] words, String target) {
        int subscript = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (target.equals(words[subscript])) {
            return subscript;
        }

        int rightNext = findNext(subscript, words, true);
        if (target.equals(words[rightNext])) {
            return rightNext;
        }
        if (target.compareTo(words[rightNext]) > 0) {
            return binarySearch(rightNext + 1, right, words, target);
        }

        int leftNext = findNext(subscript, words, false);
        if (target.equals(words[leftNext])) {
            return leftNext;
        }
        if (target.compareTo(words[leftNext]) < 0) {
            return binarySearch(left, leftNext - 1, words, target);
        }
        return -1;
    }

    public int findNext(int subscript, String[] words, boolean isRight) {
        if (subscript < 0) {
            return 0;
        }
        if (subscript > words.length - 1) {
            return words.length - 1;
        }
        if (words[subscript].equals("")) {
            if (isRight) {
                return findNext(subscript + 1, words, isRight);
            } else {
                return findNext(subscript - 1, words, isRight);
            }
        }
        return subscript;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
