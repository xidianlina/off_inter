package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的数字可以无限制重复被选取。

说明：
所有数字（包括target）都是正整数。
解集不能包含重复的组合。

示例1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]

示例2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
 [2,2,2,2],
 [2,3,3],
 [3,5]
]

提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
 */
public class lc039 {
    /*
      时间复杂度:O(S)，其中S为所有可行解的长度之和。时间复杂度取决于搜索树所有叶子节点的深度之和，即所有可行解的长度之和。
      空间复杂度:O(target)。除答案数组外，空间复杂度取决于递归的栈深度，在最差情况下需要递归O(target) 层。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        helper(candidates, target, 0, out, result);

        return result;
    }

    private void helper(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(out));
        }

        for (int i = start; i < candidates.length; ++i) {
            out.add(candidates[i]);
            helper(candidates, target - candidates[i], i, out, result);
            out.remove(out.size() - 1);
        }
    }
}
