package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class lc046 {
    /*
        时间复杂度：O(n×n!)，其中n为序列的长度。
        空间复杂度：O(n)，其中n为序列的长度。
     */
    public List<List<Integer>> permute(int[] nums) {
        // 最终返回的结果集
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        if (size == 0 || nums == null) {
            return result;
        }
        helper(nums, 0, result);

        return result;
    }

    private void helper(int[] nums, int start, List<List<Integer>> result) {
        // 将当前数组加到结果集中
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }

        // 将当前位置的数跟后面的数交换，并搜索解
        for (int i = start; i < nums.length; ++i) {
            swap(nums, i, start);
            helper(nums, start + 1, result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
