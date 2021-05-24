package leetcode;

/*
给你一个整数数组nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4

示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1

提示：
1 <= nums.length <= 2500
-104 <= nums[i] <= 104

进阶：
你可以设计时间复杂度为 O(n2) 的解决方案吗？
你能将算法的时间复杂度降低到O(nlog(n)) 吗?
 */
public class lc300 {
    /*
        方法一：动态规划
        dp[i]表示以nums[i]这个数结尾的最长递增子序列的长度。
        时间复杂度：O(n^2)，其中n为数组nums的长度。动态规划的状态数为n，计算状态dp[i] 时，需要O(n)的时间遍历dp[0…i−1]的所有状态，所以总时间复杂度为O(n^2)
        空间复杂度：O(n)，需要额外使用长度为n的dp数组。
     */
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }

        int[] dp = new int[size];
        dp[0] = 1;

        int maxLen = 1;
        for (int i = 1; i < size; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    /*
           只能把点数小的牌压到点数比它大的牌上；如果当前牌点数较大没有可以放置的堆，则新建一个堆，把这张牌放进去；
           如果当前牌有多个堆可供选择，则选择最左边的那一堆放置。
           时间复杂度：O(nlogn)。
           空间复杂度：O(n)，需要额外使用长度为n的数组。
     */
    public int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];

        // 牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /**搜索左侧边界的二分查找 **/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 没找到合适的牌堆，新建一堆
            if (left == piles) {
                piles++;
            }

            // 把这张牌放到牌堆顶
            top[left] = poker;
        }

        // 牌堆数就是LIS长度
        return piles;
    }
}
