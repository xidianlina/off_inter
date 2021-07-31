package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:
输入:n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class lc077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        helper(n, k, 1, out, result);
        return result;
    }

    private void helper(int n, int k, int start, List<Integer> out, List<List<Integer>> result) {
        if (out.size() == k) {
            result.add(new ArrayList<>(out));
        }

        for (int i = start; i <= n; ++i) {
            out.add(i);
            helper(n, k, i + 1, out, result);
            out.remove(out.size() - 1);
        }
    }
}
