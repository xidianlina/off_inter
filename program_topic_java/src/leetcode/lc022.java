package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

示例 2：
输入：n = 1
输出：["()"]

提示：
1 <= n <= 8
 */
public class lc022 {
    /*
     深度优先遍历:
     当前左右括号都有大于0个可以使用的时候，才产生分支；
     产生左分支的时候，只看当前是否还有左括号可以使用；
     产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
     在左边和右边剩余的括号数都等于0的时候结算。
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        //特判
        if (n == 0) {
            return result;
        }

        // 执行深度优先遍历，搜索可能的结果
        generateParenthesisDFS(n, n, "", result);

        return result;
    }

    private void generateParenthesisDFS(int left, int right, String out, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(out);
            return;
        }

        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数才剪枝）
        if (left > right) {
            return;
        }

        if (left > 0) {
            generateParenthesisDFS(left - 1, right, out + "(", result);
        }

        if (right > 0) {
            generateParenthesisDFS(left, right - 1, out + ")", result);
        }
    }
}
