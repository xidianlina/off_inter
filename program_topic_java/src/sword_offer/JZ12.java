package sword_offer;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * 示例1
 * 输入
 * 2,3
 * 返回值
 * 8.00000
 */
public class JZ12 {
    public double Power(double base, int exponent) {
        double res = 0;
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            res = base;
            for (int i = 1; i < exponent; i++) {
                res *= base;
            }
            return res;
        } else {
            res = base;
            int flag = -exponent;
            for (int i = 1; i < flag; i++) {
                res *= base;
            }
            return 1 / res;
        }
    }

    public double Power2(double base, int exponent) {
        double res = 0;
        if (exponent == 0) {
            return 1;
        } else {
            int flag = exponent > 0 ? exponent : -exponent;
            res = base;
            for (int i = 1; i < flag; i++) {
                res *= base;
            }
            return exponent > 0 ? res : 1 / res;
        }
    }
}
