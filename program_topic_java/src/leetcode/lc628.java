package leetcode;

import java.util.Arrays;

/*
628. 三个数的最大乘积
给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1：
输入：nums = [1,2,3]
输出：6

示例 2：
输入：nums = [1,2,3,4]
输出：24

示例 3：
输入：nums = [-1,-2,-3]
输出：-6

提示：
3 <= nums.length <=104
-1000 <= nums[i] <= 1000
 */
public class lc628 {
    /*
        时间复杂度：O(N)，其中 N 为数组长度。仅需遍历数组一次。
        空间复杂度：O(1)。
     */
    public int maximumProduct(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    /*
        首先将数组排序。
        如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积；如果全是非正数，则最大的三个数相乘同样也为最大乘积。
        如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积。
        综上，在给数组排序后，分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答案。

        时间复杂度：O(NlogN)，其中 N 为数组长度。排序需要O(NlogN) 的时间。
        空间复杂度：O(logN)，主要为排序的空间开销。
     */
    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
