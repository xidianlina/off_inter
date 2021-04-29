package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个可包含重复数字的序 nums ，按任意顺序 返回所有不重复的全排列。

示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

提示：
1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */
public class lc047 {
    /*
        时间复杂度：O(n×n!)，其中n为序列的长度。
        空间复杂度：O(n)，其中n为序列的长度。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        if (size == 0 || nums == null) {
            return result;
        }

        boolean[] used = new boolean[size];
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used, out, result);

        return result;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> out, List<List<Integer>> result) {
        if (out.size() == nums.length) {
            result.add(new ArrayList<>(out));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            // 当前位置的数已经在List中了
            if (used[i]) {
                continue;
            }

            // 当前元素与其前一个元素值相同 且 前元素未被加到list中，跳过该元素
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }

            // 深度优先搜索遍历
            used[i] = true;
            out.add(nums[i]);
            dfs(nums, used, out, result);
            out.remove(out.size() - 1);
            used[i] = false;
        }
    }
}
