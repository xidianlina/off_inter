package leetcode;

import java.util.Stack;

/*
给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。

示例 1：
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"

示例 2：
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"

示例 3：
输入：s = ""
输出：0

提示：
0 <= s.length <= 3 * 104
s[i] 为 '(' 或 ')'
 */
public class lc032 {
    /*
        时间复杂度:O(n)，nn是给定字符串的长度。只需要遍历字符串一次即可。
        空间复杂度:O(n)。栈的大小在最坏情况下会达到n，因此空间复杂度为O(n) 。
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    result = stack.isEmpty() ? Math.max(result, i - start + 1) : Math.max(result, i - stack.peek());
                }
            }
        }

        return result;
    }
}
