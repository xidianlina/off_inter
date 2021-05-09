package sword_offer;

/**
 * 题目描述
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 示例
 * 输入
 * 10
 * 返回值
 * 2
 */
public class JZ11 {
    public static void main(String[] args) {
        JZ11 jz11 = new JZ11();
        int res = jz11.NumberOf1(10);
        System.out.println(res);
        int res2 = jz11.NumberOf1_2(10);
        System.out.println(res2);
        int res3 = jz11.NumberOf1_3(10);
        System.out.println(res3);
    }

    /*
    利用&运算的特性,把一个整数减去1，再和原整数做与运算，
    会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     */
    public int NumberOf1(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    /*
    正整数的二进制数最高位为 0 ，负整数和二进制数最高们为 1 ，
    则可利用左移、判断正负来实现 1 的个数的计算。
     */
    public int NumberOf1_2(int n) {
        int res = 0;
        while (n != 0) {
            if (n < 0) {
                res++;
            }
            //左移一位,左边的最高位为符号位，根据正负数来判断符号位的0,1，从而得到1的个数
            n = n << 1;
        }
        return res;
    }

    /*
    通过位移判断奇偶数并计数，标志位初始为1，将其和输入值相与，
    n & 1 的结果为 1 或 0 ，为 1 的时候 count+=1 ，为 0 的时候 count+=0
     */
    public int NumberOf1_3(int n) {
        int res = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                res++;
            }
            flag = flag << 1;
        }
        return res;
    }
}