package leetcode;

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回[-1, -1]。

进阶：
你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]

提示：
0 <= nums.length <= 105
-10^9<= nums[i]<= 10^9
nums是一个非递减数组
-10^9<= target<= 10^9
 */
public class lc034 {
    /*
        时间复杂度:O(logn) ，其中n为数组的长度。二分查找的时间复杂度为O(logn)。
        空间复杂度:O(1) 。只需要常数空间存放若干变量。
     */
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        int[] result = {-1, -1};
        if (size == 0 || nums == null) {
            return result;
        }

        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int index = mid;
                while (index >= 0 && nums[index] == target) {
                    --index;
                }
                result[0] = index + 1;
                index = mid;
                while (index < size && nums[index] == target) {
                    ++index;
                }
                result[1] = index - 1;
                break;
            }
        }

        return result;
    }
}
