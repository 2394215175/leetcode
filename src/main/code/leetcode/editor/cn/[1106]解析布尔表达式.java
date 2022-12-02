//给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。 
//
// 有效的表达式需遵循以下约定： 
//
// 
// "t"，运算结果为 True 
// "f"，运算结果为 False 
// "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT） 
// "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND） 
// "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR） 
// 
//
// 
//
// 示例 1： 
//
// 输入：expression = "!(f)"
//输出：true
// 
//
// 示例 2： 
//
// 输入：expression = "|(f,t)"
//输出：true
// 
//
// 示例 3： 
//
// 输入：expression = "&(t,f)"
//输出：false
// 
//
// 示例 4： 
//
// 输入：expression = "|(&(t,f,t),!(t))"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20000 
// expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。 
// expression 是以上述形式给出的有效表达式，表示一个布尔值。 
// 
//
// Related Topics 栈 递归 字符串 👍 187 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final String TRUE = "t";
    final String FALSE = "f";

    public boolean parseBoolExpr(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            String cur = expression.substring(i, i + 1);
            stack.add(cur);
            if (stack.peek().equals(")")) {
                String calcSb = "";
                while (!stack.peek().equals("(")) {
                    String pop = stack.pop();
                    calcSb = pop + calcSb;
                }
                calcSb = stack.pop() + calcSb;
                calcSb = stack.pop() + calcSb;
                String calc = calc(calcSb);
                stack.add(calc);
            }
        }
        return stack.pop().equals(TRUE);
    }

    public String calc(String s) {
        String[] split = s.split("\\(|\\)|,");
        int length = split.length;
        String res = "";
        if ("!".equals(split[0])) {
            res = TRUE.equals(split[1]) ? FALSE : TRUE;
        } else if ("&".equals(split[0])) {
            for (int i = 1; i < length; i++) {
                if (FALSE.equals(split[i])) {
                    res = FALSE;
                    break;
                }
            }
            if ("".equals(res)) {
                res = TRUE;
            }
        } else {
            for (int i = 1; i < length; i++) {
                if (TRUE.equals(split[i])) {
                    res = TRUE;
                    break;
                }
            }
            if ("".equals(res)) {
                res = FALSE;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
