package leetcode;

/*
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。

示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]

示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]

示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]

示例 4：
输入：nums = [1]
输出：[1]

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 100
 */
public class lc031 {
    /*
        思路及解法:
        下一个排列总是比当前排列要大，除非该排列已经是最大的排列。希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。
        将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
        同时要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
        这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。

        时间复杂度：O(N)，其中N为给定序列的长度。至多只需要扫描两次序列，以及进行一次反转操作。
        空间复杂度：O(1),只需要常数的空间存放若干变量。
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到右边较大的数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }

        //找到左边较小的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                --j;
            }

            //交换
            swap(nums, i, j);
        }

        //反转,使较大数右边的数需要按照升序重新排列
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
