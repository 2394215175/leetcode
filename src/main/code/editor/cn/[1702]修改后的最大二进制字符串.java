//给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改： 
//
// 
// 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。 
// 
//
// 
// 比方说， "00010" -> "10010" 
// 
// 
// 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
// 
// 比方说， "00010" -> "00001" 
// 
// 
//
//
// 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制
//字符串 x 大于二进制字符串 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：binary = "000110"
//输出："111011"
//解释：一个可行的转换为：
//"000110" -> "000101" 
//"000101" -> "100101" 
//"100101" -> "110101" 
//"110101" -> "110011" 
//"110011" -> "111011"
// 
//
// 示例 2： 
//
// 
//输入：binary = "01"
//输出："01"
//解释："01" 没办法进行任何转换。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= binary.length <= 10⁵ 
// binary 仅包含 '0' 和 '1' 。 
// 
//
// Related Topics 贪心 字符串 👍 25 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        int index = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1'){
                index++;
            }else {
                break;
            }
        }
        for (int i = index; i < chars.length - 1; i++) {
            for (int j = index; j < chars.length - 1; j++) {
                if (chars[j] == '1' && chars[j + 1] == '0') {
                    chars[j] = '0';
                    chars[j + 1] = '1';
                }
            }
        }


        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '0' && chars[i + 1] == '0') {
                chars[i] = '1';
            }
        }

        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
