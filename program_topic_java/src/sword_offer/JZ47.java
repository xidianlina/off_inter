package sword_offer;

/**
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例1
 * 输入
 * 5
 * 返回值
 * 15
 */
public class JZ47 {
    public int Sum_Solution(int n) {
        if (n == 0) {
            return 0;
        }

        return n + Sum_Solution(n - 1);
    }

    public int Sum_Solution2(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution2(n - 1)) > 0);
        return sum;
    }
}
