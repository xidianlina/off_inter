LeetCode
======
https://www.cnblogs.com/xidian2014                          
https://codetop.cc/home                                    
# 算法题目
### 109.有序链表转换二叉搜索树
### 121.买卖股票的最佳时机
### 122.买卖股票的最佳时机II
### 123.买卖股票的最佳时机III
### 128.最长连续序列
### 129.求根节点到叶节点数字之和
### 136.只出现一次的数字
### 137.只出现一次的数字II
### 143.重排链表
### 146.LRU缓存机制
### 172.阶乘后的零
### 179.最大数
### 188.买卖股票的最佳时机IV
### 198.打家劫舍
### 199.二叉树的右视图
### 200.岛屿数量
### 206.反转链表
### 213.打家劫舍II
### 215.数组中的第K个最大元素
### 228.汇总区间
### 232.重排链表
### 234.回文链表
### 236.二叉树的最近公共祖先
### 239.滑动窗口最大值
### 260.只出现一次的数字 III
### 300.最长递增子序列
### 309.最佳买卖股票时机含冷冻期
### 322.零钱兑换
### 328.奇偶链表
### 337.打家劫舍 III
### 349.两个数组的交集
### 415.字符串相加
### 543.二叉树的直径(二叉树中节点的最大距离)
### 581.最短无序连续子数组
### 628.三个数的最大乘积
### 674.最长连续递增序列
### 714.买卖股票的最佳时机含手续费
### 796.旋转字符串
### 1143.最长公共子序列
### 1446.连续字符
### 1502.判断能否形成等差数列
### 1518.换水问题

# 算法解答
### 109.有序链表转换二叉搜索树
题目链接
https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/         
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/             
```java
package leetcode;

/*
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。

示例:
给定的有序链表： [-10, -3, 0, 5, 9],
一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class lc109 {
    /*
        时间复杂度：O(nlogn)，其中n是链表的长度。
        设长度为n的链表构造二叉搜索树的时间为T(n)，递推式为T(n)=2⋅T(n/2)+O(n)，根据主定理，T(n)=O(nlogn)。
        空间复杂度：O(logn)，这里只计算除了返回答案之外的空间。平衡二叉树的高度为O(logn)，即为递归过程中栈的最大深度，也就是需要的空间。
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
```
### 121.买卖股票的最佳时机
题目连接
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
```java
package leetcode;

/*
给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

示例 1：
输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

示例 2：
输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。

提示：
1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class lc121 {
    /*
        时间复杂度：O(n^2)
        空间复杂度：O(1)。只使用了常数个变量。
        运行时超时
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        //从第一个元素遍历到倒数第二个元素
        for (int i = 0; i < prices.length - 1; ++i) {
            //从第二个元素遍历到最后一个元素,保证买入在卖出前
            for (int j = i + 1; j < prices.length; ++j) {
                int profile = prices[i] - prices[j];
                if (profile > max) {
                    max = profile;
                }
            }
        }

        return max;
    }

    /*
        时间复杂度：O(n)，只需要遍历一次。
        空间复杂度：O(1)，只使用了常数个变量。
     */

    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
```
### 122.买卖股票的最佳时机II
题目连接
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
```java
package leetcode;

import sun.nio.cs.ext.MacHebrew;

/*
给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入: prices = [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

示例 2:
输入: prices = [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

示例 3:
输入: prices = [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

提示：
1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */
public class lc122 {
    /*
        因为不能同时参与多笔交易，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
        dp[i][0]表示第i天交易完后手里没有股票的最大利润，dp[i][1]表示第i天交易完后手里持有一支股票的最大利润（i从0开始）。
        考虑dp[i][0]的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即dp[i−1][0]，
        或者前一天结束的时候手里持有一支股票，即dp[i−1][1]，这时候要将其卖出，并获得prices[i]的收益。因此为了收益最大化，转移方程：
        dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}

        再来考虑dp[i][1]的转移方程，如果这一天交易完后手里有股票，那么可能是前一天已经持有一支股票，即dp[i−1][1]，
        或者前一天结束时还没有股票，即dp[i−1][0]，这一天要将买入一支股票，并减少prices[i]的收益。转移方程：
        dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}

        对于初始状态，根据状态定义可以知道第0天交易结束的时候dp[0][0]=0，dp[0][1]=−prices[0]。
        因此，只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，
        因此这时候dp[n−1][0]的收益必然是大于dp[n−1][1]的，最后的答案即为dp[n−1][0]。

        时间复杂度：O(n)，其中n为数组的长度。一共有2n个状态，每次状态转移的时间复杂度为O(1)，因此时间复杂度为O(2n)=O(n)。
        空间复杂度：O(n)。需要开辟O(n)空间存储动态规划中的所有状态。如果使用空间优化，空间复杂度可以优化至O(1)。
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }

    /*
        贪心算法
        贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程。
        时间复杂度：O(n)，其中n为数组的长度。只需要遍历一次数组即可。
        空间复杂度：O(1)。只需要常数空间存放若干变量。
     */
    public int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;

        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }

        return ans;
    }
}
```
### 123.买卖股票的最佳时机III
题目连接
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
```java
package leetcode;

/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入：prices = [3,3,5,0,0,3,1,4]
输出：6
解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。

示例 2：
输入：prices = [1,2,3,4,5]
输出：4
解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

示例 3：
输入：prices = [7,6,4,3,1]
输出：0
解释：在这个情况下, 没有交易完成, 所以最大利润为 0。

示例 4：
输入：prices = [1]
输出：0

提示：
1 <=prices.length <= 10^5
0 <=prices[i] <= 10^5
 */
public class lc123 {
    /*
        由于最多可以完成两笔交易，因此在任意一天结束之后，会处于以下五个状态中的一种：
        1.未进行过任何操作；
        2.只进行过一次买操作；
        3.进行了一次买操作和一次卖操作，即完成了一笔交易；
        4.在完成了一笔交易的前提下，进行了第二次买操作；
        5.完成了全部两笔交易。
        由于第一个状态的利润显然为0，因此可以不用将其记录。
        对于剩下的四个状态，分别将它们的最大利润记为buy1、sell1、buy2、sell2

        对于buy1，在第i天可以不进行任何操作，保持不变，也可以在未进行任何操作的前提下以prices[i]的价格买入股票，那么buy1的状态转移方程即为：
        buy1 = max{buy1,−prices[i]}

        对于sell1，在第i天可以不进行任何操作，保持不变，也可以在只进行过一次买操作的前提下以prices[i]的价格卖出股票，那么sell1的状态转移方程即为：：
        sell1 = max{sell1,buy1+prices[i]}

        对于buy2，在第i天可以不进行任何操作，保持不变，也可以在完成了一笔交易(一次买操作和一次卖操作)操作的前提下以prices[i]的价格买入股票，那么buy2的状态转移方程即为：
        buy2 = max{buy2,sell1−prices[i]}

        对于sell2，在第i天可以不进行任何操作，保持不变，也可以在完成了一笔交易之后又买了一次的前提下以prices[i]的价格卖出股票，那么sell2的状态转移方程即为：
        sell2 = max{sell2,buy2+prices[i]}

        时间复杂度：O(n)，其中n是数组prices的长度。
        空间复杂度：O(1)。
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
```
### 128.最长连续序列
题目连接      
https://leetcode.cn/problems/longest-consecutive-sequence/description/        
```java
package leetcode;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
import java.util.HashSet;
import java.util.Set;
public class lc128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;

                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLen += 1;
                }

                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }
}
```
### 129.求根节点到叶节点数字之和
题目连接      
https://leetcode.cn/problems/sum-root-to-leaf-numbers/          
```java
package leetcode;

/**
 * 给你一个二叉树的根节点root ，树中每个节点都存放有一个0到9之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * 示例 2：
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 *
 * 提示：
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 */
public class lc129 {
    public int sumNumbers(TreeNode root) {
        return dfsTree(root, 0);
    }

    public int dfsTree(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }

        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfsTree(root.left, sum) + dfsTree(root.right, sum);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```
### 136.只出现一次的数字
题目连接        
https://leetcode.cn/problems/single-number/       
```java
package leetcode;

/**
 * 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 示例 1 ：
 * 输入：nums = [2,2,1]
 * 输出：1
 *
 * 示例 2 ：
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 *
 * 示例 3 ：
 * 输入：nums = [1]
 * 输出：1
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。
 */
public class lc136 {
    /**
     * 时间复杂度：O(n)，其中n是数组长度。只需要对数组遍历一次。
     * 空间复杂度：O(1)。
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
```
### 137.只出现一次的数字II
题目连接        
https://leetcode.cn/problems/single-number-ii/        
```java
package leetcode;

/**
 *  给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次。
 *  请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 *
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 */
import java.util.HashMap;
import java.util.Map;
public class lc137 {
    /**
     * 时间复杂度：O(n)，其中 n 是数组的长度。
     * 空间复杂度：O(n)。哈希映射中包含最多 [n/3]+1 个元素，即需要的空间为 O(n)。
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();

            if (cnt == 1) {
                res = num;
                break;
            }
        }

        return res;
    }

    /**
     * 位运算:
     * 将数的二进制位每一位相加，然后对其每一位的和取余
     * 如果其他数都出现 3 次，只有目标数出现 1 次，那么每一位的 1 的个数无非有这2种情况，
     * 为 3 的倍数（全为出现三次的数） 或 3 的倍数 +1（包含出现一次的数）。这个 3 的倍数 +1 的情况也就是目标数的那一位。
     *
     * 因为 a & 1 中 1 只有最后一位为 1，其余位皆为 0 ，
     * 所以 a & 1的作用就是判断 a 的最后一位是否为 1 ，如果 a 的最后一位为 1 ，a & 1 = 1,否则为 0 。
     * 所以这个公式来判断 a 的奇偶性。
     *
     * & 按位与运算符：参与运算的两个值,如果两个相应位都为1,则该位的结果为1,否则为0
     * | 按位或运算符：只要对应的二个二进位有一个为1时，结果位就为1
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 1; i <= 32; i++) {
            int sum = 0;
            for (int num : nums) {
                int temp = num >> i & 1;
                if (temp == 1) {
                    sum++;
                }
            }
            if (sum % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }
}
```
### 143.重排链表
题目连接
https://leetcode-cn.com/problems/reorder-list/
https://leetcode.com/problems/reorder-list/
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个单链表L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class lc143 {
    /*
        时间复杂度：O(N)，其中N是链表中的节点数。
        空间复杂度：O(N)，其中N是链表中的节点数。主要为线性表的开销。
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /*
        时间复杂度：O(N)，其中 N 是链表中的节点数。
        空间复杂度：O(1)。
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode list1 = head;
        ListNode list2 = mid.next;
        mid.next = null;
        list2 = reverseList(list2);
        mergeList(list1, list2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public void mergeList(ListNode list1, ListNode list2) {
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        while (list1 != null && list2 != null) {
            tmp1 = list1.next;
            tmp2 = list2.next;

            list1.next = list2;
            list1 = tmp1;

            list2.next = list1;
            list2 = tmp2;
        }
    }
}
```

### 146.LRU缓存机制
题目链接        
https://leetcode-cn.com/problems/lru-cache/         
https://leetcode.com/problems/lru-cache/         
```java
package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
运用你所掌握的数据结构，设计和实现一个LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：
LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？

示例：
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4

提示：
1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
最多调用 3 * 104 次 get 和 put
 */
public class lc146 {
    private Queue<Integer> que;
    private Map<Integer, Integer> m;
    private int cap;

    public lc146(int capacity) {
        this.que = new LinkedList<>();
        this.m = new HashMap<Integer, Integer>();
        this.cap = capacity;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            que.remove(new Integer(key));
            que.add(key);
            return m.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            que.remove(new Integer(key));
        }

        if (que.size() == cap) {
            int val = que.poll();
            m.remove(val);
        }

        que.add(key);
        m.put(key, value);
    }
}
```
### 172.阶乘后的零
题目链接        
https://leetcode-cn.com/problems/factorial-trailing-zeroes/             
https://leetcode.com/problems/factorial-trailing-zeroes/         
```java
package leetcode;

/*
给定一个整数n，返回n!结果尾数中零的数量。

示例 1:
输入: 3
输出: 0
解释:3! = 6, 尾数中没有零。

示例2:
输入: 5
输出: 1
解释:5! = 120, 尾数中有1个零.
说明: 你算法的时间复杂度应为O(logn)。
 */
public class lc172 {
    /*
        N的阶乘可以分解为:2的X次方，3的Y次方，4的K次方，5次Z方，.....的乘积。
        由于10 = 2 * 5,所以M只能和X和Z有关，每一对2和5相乘就可以得到一个10，
        于是M = MIN(X,Z),不难看出X大于Z，因为被2整除的频率比被5整除的频率高的多。
        所以可以把公式简化为M=Z。
     */
    public int trailingZeroes(int n) {
        if (n < 0) {
            return 0;
        }
        int res = 0;
        for (int i = 5; i <= n; ++i) {
            int j = i;
            while (j % 5 == 0) {
                ++res;
                j = j / 5;
            }
        }
        return res;
    }

    /*
        时间复杂度:O(logn)。在这种方法中,将n除以5的每个幂。根据定义，5的log5n幂小于或等于n。
        由于乘法和除法在32位整数范围内，将这些计算视为O(1)。因此，正在执行log5nxO(1)=logn操作
        空间复杂度:O(1)，只是用了常数空间。
     */
    public int trailingZeroes2(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
```
### 179.最大数
题目链接                
https://leetcode-cn.com/problems/largest-number/            
https://leetcode.com/problems/largest-number/        
```java
package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

示例 1：
输入：nums = [10,2]
输出："210"

示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"

示例 3：
输入：nums = [1]
输出："1"

示例 4：
输入：nums = [10]
输出："10"

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 109
 */
public class lc179 {
    /*
        时间复杂度：O(nlognlogm)，其中n是给定序列的长度，m是32位整数的最大值，每个数转化为字符串后的长度是O(logm) 的数量级。
        排序比较函数的时间复杂度为O(logm)，共需要进行O(nlogn) 次比较。同时需要对字符串序列进行拼接，时间复杂度为O(nlogm)，
        在渐进意义上小于O(nlognlogm)。
        空间复杂度：O(logn)，排序需要O(logn) 的栈空间。
     */
    public String largestNumber(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return "";
        }

        String[] strs = new String[size];
        for (int i = 0; i < size; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        return strs[0].equals("0") ? "0" : String.join("", strs);
    }
}
```
### 188.买卖股票的最佳时机IV
题目链接                    
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/                    
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/                   
```java
package leetcode;

import java.util.Arrays;

/*
给定一个整数数组prices ，它的第i个元素prices[i] 是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1：
输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

示例 2：
输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

提示：
0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
 */
public class lc188 {
    /*
        时间复杂度：O(n*min(n,k))，其中n是数组prices的大小，即使用二重循环进行动态规划需要的时间。
        空间复杂度：O(min(n,k))。

        本题中k的最大值可以达到10^9 ，然而这是毫无意义的，因为n天最多只能进行n/2笔交易，其中[x]表示对x向下取整。
        因此可以将k对[n/2]取较小值之后再进行动态规划。
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }
}
```
### 198.打家劫舍
题目链接            
https://leetcode-cn.com/problems/house-robber/              
https://leetcode.com/problems/house-robber/              
```java
package leetcode;

/*
198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
一夜之内能够偷窃到的最高金额。

示例 1：
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2：
输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class lc198 {
    /*
        动态规划：
        如果只有一间房屋，则偷窃该房屋，可以偷窃到最高总金额。
        如果只有两间房屋，则由于两间房屋相邻，不能同时偷窃，只能偷窃其中的一间房屋，因此选择其中金额较高的房屋进行偷窃，可以偷窃到最高总金额。
        如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？
        对于第k(k>2) 间房屋，有两个选项：
        偷窃第k间房屋，那么就不能偷窃第k-1间房屋，偷窃总金额为前k-2间房屋的最高总金额与第k间房屋的金额之和。
        不偷窃第k间房屋，偷窃总金额为前k−1间房屋的最高总金额。
        在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前k间房屋能偷窃到的最高总金额。

        用dp[i]表示前i间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
        dp[i] = max(dp[i-2]+nums[i],dp[i-1])
        边界条件为：
        dp[0] = nums[0] 只有一间房屋，则偷窃该房屋
        dp[1] = max(nums[0], nums[1])  只有两间房屋，选择其中金额较高的房屋进行偷窃
        最终的答案即为dp[n−1]，其中n是数组的长度。

        时间复杂度：O(n)，其中n是数组长度。只需要对数组遍历一次。
        空间复杂度：O(1)。
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[len - 1];
    }

    /*
        考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，
        因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。

        时间复杂度：O(n)，其中n是数组长度。只需要对数组遍历一次。
        空间复杂度：O(1)。使用滚动数组，可以只存储前两间房屋的最高总金额，而不需要存储整个数组的结果，因此空间复杂度是O(1)。
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }

        return second;
    }
}
```
 
### 199.二叉树的右视图
题目链接            
https://leetcode-cn.com/problems/binary-tree-right-side-view/           
https://leetcode.com/problems/binary-tree-right-side-view/
```java
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例 1:
输入:[1,2,3,null,5,null,4]
输出:[1,3,4]
示例 2:

输入:[1,null,3]
输出:[1,3]
示例 3:

输入:[]
输出:[]

提示:
二叉树的节点个数的范围是 [0,100]
-100<= Node.val <= 100
 */
public class lc199 {
    /*
        时间复杂度 : O(n)。 每个节点最多进队列一次，出队列一次，因此广度优先搜索的复杂度为线性。
        空间复杂度 : O(n)。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int node = 1;
        while (!que.isEmpty()) {
            root = que.poll();
            --node;
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }
            if (node == 0) {
                res.add(root.val);
                node = que.size();
            }
        }
        return res;
    }
}
```
### 200.岛屿数量
题目链接            
https://leetcode-cn.com/problems/number-of-islands/         
https://leetcode.com/problems/number-of-islands/         
```java
package leetcode;

/*
给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

示例 1：
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1

示例 2：
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3

提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
 */
public class lc200 {
    /*
        深度优先搜索：
            可以将二维网格看成一个无向图，竖直或水平相邻的1之间有边相连。
            为了求出岛屿的数量，可以扫描整个二维网格。如果一个位置为1，
            则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，
            每个搜索到的1都会被重新标记为0。最终岛屿的数量就是进行深度优先搜索的次数。

        时间复杂度：O(MN)，其中M和N分别为行数和列数。
        空间复杂度：O(min(M,N))，在最坏情况下，整个网格均为陆地，队列的大小可以达到min(M,N)。
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (grid[r][c] == '1') {
                    ++count;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;

        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
```
### 206.反转链表
题目链接        
https://leetcode-cn.com/problems/reverse-linked-list/       
https://leetcode.com/problems/reverse-linked-list/
```java
package leetcode;

/*
206. 反转链表
反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class lc206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        head = reverseList(p.next);
        p.next.next = p;
        p.next = null;

        return head;
    }
}
```
### 213.打家劫舍II
题目链接            
https://leetcode-cn.com/problems/house-robber-ii/           
https://leetcode.com/problems/house-robber-ii/           
```java
package leetcode;

/*
213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
给定一个代表每个房屋存放金额的非负整数数，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

示例 2：
输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 3：
输入：nums = [0]
输出：0

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */
public class lc213 {
    /*
        时间复杂度：O(n)，其中n是数组长度。需要对数组遍历两次，计算可以偷窃到的最高总金额。
        空间复杂度：O(1)。
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }

        return second;
    }
}
```
### 215.数组中的第K个最大元素
题目链接            
https://leetcode-cn.com/problems/kth-largest-element-in-an-array/           
https://leetcode.com/problems/kth-largest-element-in-an-array/           
```java
package leetcode;

import java.util.Random;

/*
215. 数组中的第K个最大元素
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

提示：
1 <= k <= nums.length <= 104
-104<= nums[i] <= 104
 */
public class lc215 {
    /*
        方法一：基于快速排序的选择方法
        时间复杂度：O(n)
        空间复杂度：O(logn)
     */
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }

        swap(a, i + 1, r);

        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*
        方法二：基于堆排序的选择方法
        时间复杂度：O(nlogn)
        空间复杂度：O(logn)
     */
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }
}
```
### 228.汇总区间
题目链接        
https://leetcode-cn.com/problems/summary-ranges/          
https://leetcode.com/problems/summary-ranges/        
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个无重复元素的有序整数数组 nums 。
返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
列表中的每个区间范围 [a,b] 应该按如下格式输出：
"a->b" ，如果 a != b
"a" ，如果 a == b

示例 1：
输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

示例 2：
输入：nums = [0,2,3,4,6,8,9]
输出：["0","2->4","6","8->9"]
解释：区间范围是：
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

示例 3：
输入：nums = []
输出：[]

示例 4：
输入：nums = [-1]
输出：["-1"]

示例 5：
输入：nums = [0]
输出：["0"]

提示：
0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
nums 中的所有值都 互不相同
nums 按升序排列
 */
public class lc228 {
    /*
        时间复杂度：O(n)，其中n为数组的长度。
        空间复杂度：O(1)。除了用于输出的空间外，额外使用的空间为常数。
     */
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < n) {
            int j = 1;
            while (i + j < n && nums[i + j] - nums[i] == j) {
                ++j;
            }
            res.add(j == 1 ? String.valueOf(nums[i]) : String.valueOf(nums[i]) + "->" + String.valueOf(nums[i + j - 1]));

            i += j;
        }

        return res;
    }
}
```
### 232. 用栈实现队列
题目连接
https://leetcode-cn.com/problems/implement-queue-using-stacks/          
https://leetcode.com/problems/implement-queue-using-stacks/
```java
package leetcode;

import java.util.Stack;

/*
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
实现 MyQueue 类：
void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false

说明：
你只能使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。

进阶：
你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。

示例：
输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]

解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

提示：
1 <= x <= 9
最多调用 100 次 push、pop、peek 和 empty
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 */
public class MyQueue {
    // 两个栈实现先入先出队列
    private Stack<Integer> stkPush;
    private Stack<Integer> stkPop;

    public MyQueue() {
        stkPush = new Stack<>();
        stkPop = new Stack<>();
    }

    public void push(int x) {
        stkPush.push(x);
    }

    public int pop() {
        if (stkPop.isEmpty()) {
            while (!stkPush.isEmpty()) {
                stkPop.push(stkPush.pop());
            }
        }

        return stkPop.pop();
    }

    public int peek() {
        if (stkPop.isEmpty()) {
            while (!stkPush.isEmpty()) {
                stkPop.push(stkPush.pop());
            }
        }

        return stkPop.peek();
    }

    public boolean empty() {
        return stkPush.isEmpty() && stkPop.isEmpty();
    }
}

class MyQueue2 {
    // 一个栈实现先入先出队列
    private Stack<Integer> stk;

    public MyQueue2() {
        stk = new Stack<>();
    }

    public void push(int x) {
        stk.add(0, x);
    }

    public int pop() {
        return stk.pop();
    }

    public int peek() {
        return stk.peek();
    }

    public boolean empty() {
        return stk.isEmpty();
    }
}
```
### 234.回文链表        
题目链接             
https://leetcode.cn/problems/binary-tree-right-side-view/                   
```java
package leetcode;

/**
 * 给你一个单链表的头节点head,请你判断该链表是否为回文链表。如果是返回true；否则返回false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
import java.util.ArrayList;
import java.util.List;
public class lc234 {
    /**
     * 时间复杂度：O(n)，其中n指的是链表的元素个数。
     * 第一步：遍历链表并将值复制到数组中，O(n)。
     * 第二步：双指针判断是否为回文，执行了 O(n/2) 次的判断，即 O(n)。
     * 总的时间复杂度：O(2n)=O(n)。
     * 空间复杂度：O(n)，其中 n 指的是链表的元素个数，使用了一个数组列表存放链表的元素值。
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        List<Integer> list = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        // 使用双指针判断是否回文
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * 时间复杂度：O(n)，其中n指的是链表的大小。
     * 空间复杂度：O(1)。只修改原本链表中节点的指向，而在堆栈上的堆栈帧不超过 O(1)。
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null){
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
```
### 236.二叉树的最近公共祖先          
题目链接            
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/               
![lc236](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc236.png)
```java
package leetcode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树T的两个节点p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */
public class lc236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
```
### 239.滑动窗口最大值         
题目链接            
https://leetcode.cn/problems/sliding-window-maximum/description/                                
```java
package leetcode;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
import java.util.Deque;
import java.util.LinkedList;
public class lc239 {
    /**
     * 由于需要求出的是滑动窗口的最大值，如果当前的滑动窗口中有两个下标 i 和 j，其中 i 在 j 的左侧（i<j），
     * 并且 i 对应的元素不大于 j 对应的元素（nums[i]≤nums[j]），那么会发生什么呢？
     * 当滑动窗口向右移动时，只要 i 还在窗口中，那么 j 一定也还在窗口中，这是 i 在 j 的左侧所保证的。
     * 因此，由于 nums[j] 的存在，nums[i] 一定不会是滑动窗口中的最大值了，可以将 nums[i] 永久地移除。
     *
     * 因此可以使用一个队列存储所有还没有被移除的下标。在队列中，这些下标按照从小到大的顺序被存储，
     * 并且它们在数组 nums 中对应的值是严格单调递减的。因为如果队列中有两个相邻的下标，它们对应的值相等或者递增，
     * 那么令前者为 i，后者为 j，就对应了上面所说的情况，即 nums[i] 会被移除，这就产生了矛盾。
     *
     * 当滑动窗口向右移动时，需要把一个新的元素放入队列中。为了保持队列的性质，会不断地将新的元素与队尾的元素相比较，
     * 如果前者大于等于后者，那么队尾的元素就可以被永久地移除，将其弹出队列。
     * 需要不断地进行此项操作，直到队列为空或者新的元素小于队尾的元素。
     *
     * 由于队列中下标对应的元素是严格单调递减的，因此此时队首下标对应的元素就是滑动窗口中的最大值。
     * 此时的最大值可能在滑动窗口左边界的左侧，并且随着窗口向右移动，它永远不可能出现在滑动窗口中了。
     * 因此还需要不断从队首弹出元素，直到队首元素在窗口中为止。
     *
     * 为了可以同时弹出队首和队尾的元素，需要使用双端队列。
     *
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。每一个下标恰好被放入队列一次，并且最多被弹出队列一次，因此时间复杂度为 O(n)。
     * 空间复杂度：O(k)。使用的数据结构是双向的，因此「不断从队首弹出元素」保证了队列中最多不会有超过 k+1 个元素，因此队列使用的空间为 O(k)。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
```
### 260.只出现一次的数字 III
题目链接            
https://leetcode.cn/problems/single-number-iii/                     
```java
package leetcode;

/**
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 *
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 *
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 *
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 *
 * 提示：
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 */
public class lc260 {
    /**
     * 对数组中的数字进行 异或 运算，那么最后的结果一定是只出现一次的两个数字的异或运算结果。
     *
     * 假设只出现一次的两个数是 x 和 y 那么最后的结果是x ^ y：
     *
     * 因为x、 y 是不相同的，所以他们肯定在二进制有不同的1值；
     * 可以使用 （x ^ y） & (- x ^ y) 得到最低的那一位1:
     * 根据该位置是否为1，将数组中的数字分成两组；
     * 对这两组分别做异或运算，就可得到只出现一次的两个值
     */
    public int[] singleNumber(int[] nums) {
        int diff = 0;

        for (int num : nums) {
            diff ^= num;
        }

        // 得到最低位的1
        int group = diff & (-diff);

        int[] res = new int[2];
        for (int num : nums) {
            // 分组位为0
            if ((group & num) == 0) {
                res[0] ^= num;
            } else {
                // 分组位为1
                res[1] ^= num;
            }
        }

        return res;
    }
}
```
### 300.最长递增子序列
题目链接            
https://leetcode-cn.com/problems/longest-increasing-subsequence/           
https://leetcode.com/problems/longest-increasing-subsequence/               
```java
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
```
### 309.最佳买卖股票时机含冷冻期
题目链接                
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/             
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/            
```java
package leetcode;

/*
给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

示例:
输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class lc309 {
    /*
        时间复杂度：O(n)，其中n为数组prices 的长度。
        空间复杂度：O(1)。
    */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
```
### 322.零钱兑换
题目链接        
https://leetcode-cn.com/problems/coin-change/submissions/           
https://leetcode.com/problems/coin-change/submissions/           
```java
package leetcode;

import java.util.Arrays;

/*
给定不同面额的硬币coins和一个总金额amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
你可以认为每种硬币的数量是无限的。

示例1：
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1

示例 2：
输入：coins = [2], amount = 3
输出：-1

示例 3：
输入：coins = [1], amount = 0
输出：0

示例 4：
输入：coins = [1], amount = 1
输出：1

示例 5：
输入：coins = [1], amount = 2
输出：2

提示：
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4
 */
public class lc322 {
    /*
        维护一个一维动态数组dp，其中dp[i]表示钱数为i时的最小硬币数的找零
        更新dp[i]的方法就是遍历每个硬币，如果遍历到的硬币值小于等于i值时，用dp[i - coins[j]]+1来更新dp[i]，
        所以状态转移方程为:dp[i] = min(dp[i], dp[i - coins[j]] + 1)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```

### 328.奇偶链表
题目链接    
https://leetcode-cn.com/problems/odd-even-linked-list/      
https://leetcode.com/problems/odd-even-linked-list/     
```java
package leetcode;

/*
 328. 奇偶链表
 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 示例 1:
 输入: 1->2->3->4->5->NULL
 输出: 1->3->5->2->4->NULL
 示例 2:
 输入: 2->1->3->5->6->4->7->NULL
 输出: 2->3->6->7->1->5->4->NULL
 说明:
 应当保持奇数节点和偶数节点的相对顺序。
 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class lc328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = tmp;
            pre = pre.next;
            cur = cur.next;
        }

        return head;
    }
}
```
### 337.打家劫舍 III
题目链接            
https://leetcode-cn.com/problems/house-robber-iii/          
https://leetcode.com/problems/house-robber-iii/      
```java
package leetcode;

/*
337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:
输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.

示例 2:
输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释:小偷一晚能够盗取的最高金额= 4 + 5 = 9.
 */
public class lc337 {
    /*
        一棵二叉树，树上的每个点都有对应的权值，每个点有两种状态（选中和不选中），
        问在不能同时选中有父子关系的点的情况下，能选中的点的最大权值和是多少。
        可以用f(o)表示选择o节点的情况下，o节点的子树上被选择的节点的最大权值和；
        g(o) 表示不选择o节点的情况下，o节点的子树上被选择的节点的最大权值和；
        l和r代表o的左右孩子。
        当o被选中时，o的左右孩子都不能被选中，故o被选中情况下子树上被选中点的最大权值和为
        l和r不被选中的最大权值和相加，即 f(o) = g(l) + g(r)。
        当o不被选中时，o的左右孩子可以被选中，也可以不被选中。对于o的某个具体的孩子x，
        它对o的贡献是x被选中和不被选中情况下权值和的较大值。
        故g(o) = max{f(l),g(l)}+max{f(r),g(r)}。
        
        时间复杂度：O(n)。
        空间复杂度：O(n)。
     */
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
```
### 349.两个数组的交集
题目链接                     
https://leetcode-cn.com/problems/intersection-of-two-arrays/                    
https://leetcode.com/problems/intersection-of-two-arrays/                                     
```java
package leetcode;

import java.util.*;

/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

说明：
输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序
 */
public class lc349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<Integer>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            //放入时候去掉重复的
            nums.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums.contains(nums1[i])) {
                //放入交集
                result.add(nums1[i]);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            //集合变数组
            res[i++] = (int) iter.next();
        }
        return res;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            m.put(num, 1);
        }
        for (int num : nums2) {
            if (m.containsKey(num)) {
                //放入交集
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            //集合变数组
            res[i++] = (int) iter.next();
        }
        return res;
    }
}
```
### 415.字符串相加
题目链接            
https://leetcode-cn.com/problems/add-strings/                
https://leetcode.com/problems/add-strings/          
```java
package leetcode;

/*
415. 字符串相加
给定两个字符串形式的非负整数num1 和num2，计算它们的和。

提示：
num1 和num2的长度都小于 5100
num1 和num2 都只包含数字0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 */
public class lc415 {
    /*
        时间复杂度：O(max(len1,len2))，其中len1=num 1.length，len2=num2.length。竖式加法的次数取决于较大数的位数。
        空间复杂度：O(1)
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuffer ans = new StringBuffer();

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            ans.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }

        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
```

### 543.二叉树的直径(二叉树中节点的最大距离)
题目链接            
https://leetcode-cn.com/problems/diameter-of-binary-tree/       
https://leetcode.com/problems/diameter-of-binary-tree/           
```java
package leetcode;

/*
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
这条路径可能穿过也可能不穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class lc543 {
    /*
        一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
        而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。
        
        时间复杂度:O(N)，其中N为二叉树的节点数，即遍历一棵二叉树的时间复杂度，每个结点只被访问一次。
        空间复杂度:O(Height)，其中Height为二叉树的高度。由于递归函数在递归过程中需要为每一层递归函数分配栈空间，
        所以这里需要额外的空间且该空间取决于递归的深度，而递归的深度显然为二叉树的高度，并且每次递归调用的函数里又只用了常数个变量，
        所以所需空间复杂度为O(Height)。
     */

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        getDepth(root);

        return ans - 1;
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            // 访问到空节点了，返回0
            return 0;
        }

        // 左儿子为根的子树的深度
        int left = getDepth(node.left);
        // 右儿子为根的子树的深度
        int right = getDepth(node.right);

        // 以该节点为起点的路径经过节点数的最大值为left+right+1
        ans = Math.max(ans, left + right + 1);

        // 返回该节点为根的子树的深度
        return Math.max(left, right) + 1;
    }
}
```
### 581.最短无序连续子数组
题目连接
https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/                     
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/                        
```java
package leetcode;

/*
给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
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
}
```

### 628.三个数的最大乘积
题目链接                
https://leetcode-cn.com/problems/maximum-product-of-three-numbers/          
https://leetcode.com/problems/maximum-product-of-three-numbers/          
```java
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
```
### 674.最长连续递增序列
题目链接        
https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/         
https://leetcode.com/problems/longest-continuous-increasing-subsequence/         
```java
package leetcode;

/*
给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

示例 1：
输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。

示例 2：
输入：nums = [2,2,2,2,2]
输出：1
解释：最长连续递增序列是 [2], 长度为1。

提示：
0 <= nums.length <= 104
-109 <= nums[i] <= 109
 */
public class lc674 {
    /*
        时间复杂度：O(n)，其中n是数组nums的长度。需要遍历数组一次。
        空间复杂度：O(1)。额外使用的空间为常数。
     */
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}
```

### 714.买卖股票的最佳时机含手续费
题目链接                    
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/              
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/                     
```java
package leetcode;

/*
给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee代表了交易股票的手续费用。
你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
返回获得利润的最大值。
注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

示例 1:
输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:
在此处买入prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8

注意:
0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
 */
public class lc714 {
    /*
        不能同时参与多笔交易，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
        定义状态dp[i][0]表示第i天交易完后手里没有股票的最大利润，
        dp[i][1]表示第i天交易完后手里持有一支股票的最大利润（i从0开始）。

        时间复杂度：O(n)，其中n为数组的长度。一共有2n个状态，每次状态转移的时间复杂度为O(1)，因此时间复杂度为O(2n)=O(n)。
        空间复杂度：O(n)。
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
```
### 796.旋转字符串
题目链接                    
https://leetcode-cn.com/problems/rotate-string/                            
https://leetcode.com/problems/rotate-string/                    
```java
package leetcode;

import java.util.Arrays;

/*
给定两个字符串, A和B。
A的旋转操作就是将A最左边的字符移动到最右边。例如, 若A = 'abcde'，在移动一次之后结果就是'bcdea'。如果在若干次旋转操作之后，A能变成B，那么返回True。

示例 1:
输入: A = 'abcde', B = 'cdeab'
输出: true

示例 2:
输入: A = 'abcde', B = 'abced'
输出: false
注意：
A和B长度不超过100。
 */
public class lc796 {
    /*
        方法一：穷举法
        时间复杂度：O(N^2)，其中N是字符串 A 的长度。
        空间复杂度：O(1)。
     */
    public boolean rotateString(String A, String B) {
        if (A.equals("") && B.equals("")) {
            return true;
        }

        int len = A.length();
        for (int i = 0; i < len; ++i) {
            String begin = A.substring(0, 1);
            String end = A.substring(1, len);
            A = end + begin;
            if (A.equals(B)) {
                return true;
            }
        }

        return false;
    }

    /*
        方法二：判断子串
        时间复杂度：O(N^2)，其中N是字符串 A 的长度。
        空间复杂度：O(1)。
     */
    public boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    /*
        方法三：KMP算法
        时间复杂度：O(N)，其中N是字符串A的长度。
        空间复杂度：O(N)。
     */
    public boolean rotateString3(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int i = 0;
        int j = -1;
        int BSize = B.length();
        int[] next = new int[BSize + 1];
        next[0] = -1;
        while (i < BSize) {
            if (j == -1 || B.charAt(i) == B.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        A = A + A;
        int ASize = A.length();
        i = 0;
        j = 0;
        while (i < ASize && j < BSize) {
            if (j == -1 || A.charAt(i) == B.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }

        if (j == BSize) {
            return true;
        }

        return false;
    }
}
```
### 1143.最长公共子序列
题目链接                    
https://leetcode-cn.com/problems/longest-common-subsequence/                            
https://leetcode.com/problems/longest-common-subsequence/                          
> ![lc1143](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc1143.png)            
```java
package leetcode;

import java.util.Map;

/*
给定两个字符串text1和text2，返回这两个字符串的最长公共子序列的长度。如果不存在 公共子序列 ，返回0。
一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

示例 1：
输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。

示例 2：
输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc" ，它的长度为 3 。

示例 3：
输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0 。

提示：
1 <= text1.length, text2.length <= 1000
text1 和text2 仅由小写英文字符组成。
 */
public class lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
```
### 1446.连续字符           
题目链接            
https://leetcode.cn/problems/consecutive-characters/                            
```java
package leetcode;

/**
 * 给你一个字符串s,字符串的能量定义为:只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串 s 的 能量。
 *
 * 示例 1：
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 *
 * 示例 2：
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */
public class lc1446 {
    /*
    时间复杂度：O(n)，其中n是字符串s的长度。遍历一次s的时间复杂度为O(n)。
    空间复杂度：O(1)。只需要常数的空间保存若干变量。
     */
    public int maxPower(String s) {
        int size = s.length();
        if (size == 0 || s.isEmpty()) {
            return 0;
        }

        int curLen = 1;
        int maxLen = 1;
        char c = s.charAt(0);
        for (int i = 1; i < size; i++) {
            char t = s.charAt(i);
            if (c == t) {
                curLen++;
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
            } else {
                curLen = 1;
                c = t;
            }
        }

        return maxLen;
    }
}
```
### 1502.判断能否形成等差数列
题目链接                
https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/                                         
https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/                                      
```java
package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给你一个数字数组 arr 。
如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。

示例 1：
输入：arr = [3,5,1]
输出：true
解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。

示例 2：
输入：arr = [1,2,4]
输出：false
解释：无法通过重新排序得到等差数列。

提示：
2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6
 */
public class lc1502 {
    /*
        时间复杂度：O(nlogn)。排序的时间代价为O(n*logn)，遍历序列的时间代价是O(n)，故渐进时间复杂度为 O(n*log n + n) = O(n*logn)。
        空间复杂度：O(logn)。快速排序中使用的栈空间期望是O(logn)。
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /*
        时间复杂度：O(n)
        空间复杂度：O(n)
     */
    public boolean canMakeArithmeticProgression2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();

        //对数组进行第一次遍历,找出数组中min ,max
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            set.add(i);
        }

        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        }

        //求得公差
        int diff = (max - min) / (arr.length - 1);

        for (int i = min + diff; i < max; i += diff) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
```
### 1518.换水问题     
题目链接     
https://leetcode.cn/problems/water-bottles/solutions/1/1518-huan-shui-wen-ti-ti-jie-by-leer-e-addn/           
```java
/**
 * 超市正在促销，你可以用numExchange个空水瓶从超市兑换一瓶水。最开始，你一共购入了numBottles瓶水。
 * 如果喝掉了水瓶中的水，那么水瓶就会变成空的。
 * 给你两个整数 numBottles 和 numExchange ，返回你 最多 可以喝到多少瓶水。
 *
 * 示例 1：
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空瓶兑换 1 瓶水。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶水。
 *
 * 示例 2：
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空瓶兑换 1 瓶水。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶水。
 *
 * 提示：
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 */
public class lc1518 {
    /*
    时间复杂度：O(b/e)
    空间复杂度：O(1)
    */
    public int numWaterBottles(int b, int e) {
        if (b < e) {
            return b;
        }
        int ans = b;
        while (b >= e) {
            int f = b / e;
            int g = b % e;
            ans += f;
            b = f + g;
        }
        return ans;
    }

    public int numWaterBottles2(int b, int e) {
        if (b < e) {
            return b;
        }
        int ans = b;
        while (b >= e) {
            b -= e;
            ans++;
            b++;
        }
        return ans;
    }
}
```