package leetcode;

/*
7.整数反转
给你一个32位的有符号整数x ，返回将x中的数字部分反转后的结果。
如果反转后整数超过32位的有符号整数的范围[−2的31次方,2的31次方−1] ，就返回 0。
假设环境不允许存储64位整数（有符号或无符号）。
示例 1：
输入：x = 123
输出：321
示例 2：
输入：x = -123
输出：-321
示例 3：
输入：x = 120
输出：21
示例 4：
输入：x = 0
输出：0
提示：
-2的31次方 <= x <= 2的31次方 - 1
 */
public class lc007 {
    /*
        时间复杂度：O(log∣x∣)。翻转的次数即 x 十进制的位数。
        空间复杂度：O(1)。
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }

        return res;
    }
}
