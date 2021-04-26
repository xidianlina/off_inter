package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c ，使得a + b + c = 0 ？请你找出所有和为0且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

示例 2：
输入：nums = []
输出：[]

示例 3：
输入：nums = [0]
输出：[]

提示：
0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class lc015 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int size = nums.length;
        if (size < 3 || nums == null) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < size - 2; ++i) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = size - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    while (l < r && nums[++l] == nums[l - 1]) ;
                } else if (sum > target) {
                    while (l < r && nums[--r] == nums[r + 1]) ;
                } else {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);
                    while (l < r && nums[++l] == nums[l - 1]) ;
                    while (l < r && nums[--r] == nums[r + 1]) ;
                }
            }
        }
        return res;
    }
}
