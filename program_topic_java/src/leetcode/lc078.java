package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个整数数组nums ，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

示例 2：
输入：nums = [0]
输出：[[],[0]]

提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同
 */
public class lc078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, out, result);
        return result;
    }

    private void helper(int[] nums, int start, List<Integer> out, List<List<Integer>> result) {
        result.add(new ArrayList<>(out));
        for (int i = start; i < nums.length; ++i) {
            out.add(nums[i]);
            helper(nums, i + 1, out, result);
            out.remove(out.size() - 1);
        }
    }
}
