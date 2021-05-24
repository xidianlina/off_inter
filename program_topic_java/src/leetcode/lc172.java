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
