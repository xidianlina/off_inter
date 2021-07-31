package leetcode;

/*
581. 最短无序连续子数组
给你一个整数数组 nums ，你需要找出一个连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
请你找出符合题意的 最短 子数组，并输出它的长度。

示例 1：
输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

示例 2：
输入：nums = [1,2,3,4]
输出：0

示例 3：
输入：nums = [1]
输出：0

提示：
1 <= nums.length <= 104
-105 <= nums[i] <= 105

进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 */
public class lc581 {
    /*
        无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
        首先需要找到原数组在哪个位置开始不是升序的。从头开始遍历数组，一旦遇到降序的元素，记录最小元素为min 。
        逆序扫描数组nums，当数组出现升序的时候，记录最大元素为max。
        再次遍历nums数组并通过与其他元素进行比较，来找到min和max在原数组中的正确位置。只需要从头开始找到第一个大于min的元素，
        从尾开始找到第一个小于max的元素，它们之间就是最短无序子数组。

        时间复杂度：O(n)。使用了4个O(n)的循环。
        空间复杂度：O(1)。使用了常数空间。
     */
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
            }
        }
        int left, right;
        for (left = 0; left < nums.length; left++) {
            if (min < nums[left]) {
                break;
            }
        }
        for (right = nums.length - 1; right >= 0; right--) {
            if (max > nums[right]) {
                break;
            }
        }
        return right - left < 0 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3, 90, 8, 10, 9, 15, 16, 18};
        lc581 main = new lc581();
        int res = main.findUnsortedSubarray(arr);
        System.out.println(res);
    }
}
