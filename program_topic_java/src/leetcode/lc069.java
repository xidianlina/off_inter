package leetcode;

/*
69. x 的平方根
实现int sqrt(int x)函数。
计算并返回x的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:
输入: 4
输出: 2

示例 2:
输入: 8
输出: 2

说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 */
public class lc069 {
    /*
        方法一：暴力解
        时间复杂度：O(logx)，即为二分查找需要的次数。
        空间复杂度：O(1)。
     */
    public int mySqrt(int x) {
        if (x < 0) {
            return x;
        }

        int begin = 1;
        int end = x;
        int mid = 0;
        while (begin <= end) {
            mid = (begin + end) >> 1;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // 结束条件end一定<begin，所以返回end
        return end;
    }

    /*
         牛顿迭代法
         时间复杂度：O(logx)，此方法是二次收敛的，相较于二分查找更快。
         空间复杂度：O(1)。
     */
    public int mySqrt2(int x) {
        if (x < 0) {
            return x;
        }

        long v = x;
        while (v * v > x) {
            v = (v + x / v) / 2;
        }

        return (int) v;
    }
}
