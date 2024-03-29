package leetcode;

import java.util.Stack;

/*
20. 有效的括号
给定一个只包括'('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

示例 1：
输入：s = "()"
输出：true

示例2：
输入：s = "()[]{}"
输出：true

示例3：
输入：s = "(]"
输出：false

示例4：
输入：s = "([)]"
输出：false

示例5：
输入：s = "{[]}"
输出：true

提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */
public class lc020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Character now;
        Character prev;
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            now = s.charAt(i);
            if (now == '(' || now == '[' || now == '{') {
                stack.push(now);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    prev = stack.pop();
                }

                if (now == ')' && prev != '(') {
                    return false;
                } else if (now == ']' && prev != '[') {
                    return false;
                } else if (now == '}' && prev != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
