package leetcode;

/*
29. 两数相除
给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和mod运算符。
返回被除数dividend除以除数divisor得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

示例2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

提示：
被除数和除数均为32位有符号整数。
除数不为0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31− 1]。本题中，如果除法结果溢出，则返回 2^31− 1。
 */
public class lc029 {
    /*
      位操作Bit Operation，思路是:如果被除数大于或等于除数，则进行如下循环，定义变量t等于除数，定义计数p，
      当t的两倍小于等于被除数时，进行如下循环，t扩大一倍，p扩大一倍，然后更新res和m。
      通过不断的二进制向左位移，判断除数(divisor)位移几次后，最接近被除数(dividend)。获取到最接近的值，用被除数减去最接近的值。
      并重复上述过程，同时记录每次位移至最接近的值所需要的2的幂次方。将所有位移致最接近的值所需要的2幂次方叠加起来，就是最终的结果了。
     */
    public int divide(int dividend, int divisor) {
        int res = 0;
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);
        while (m >= n) {
            long t = n, p = 1;
            while (m >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return res;
        } else {
            return -res;
        }
    }
}
