package sword_offer;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。39n≤39
 * 示例
 * 输入
 * 4
 * 返回值
 * 3
 */
public class JZ07 {
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int Fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int temp = 0;
        int pre = 0;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            temp = res;
            res = pre + res;
            pre = temp;
        }

        return res;
    }
}
