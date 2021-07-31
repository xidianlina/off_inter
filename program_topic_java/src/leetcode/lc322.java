package leetcode;

import java.util.Arrays;

/*
322. 零钱兑换
给定不同面额的硬币coins和一个总金额amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回-1。
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

        时间复杂度：O(Sn)，其中S是金额，n是面额数。一共需要计算O(S)个状态，S为题目所给的总金额。
                  对于每个状态，每次需要枚举n个面额来转移状态，所以一共需要O(Sn)的时间复杂度。
        空间复杂度：O(S)。数组dp需要开长度为总金额S的空间。
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
