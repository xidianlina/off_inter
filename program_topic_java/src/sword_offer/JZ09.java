package sword_offer;

/**
 * 题目描述:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 示例1
 * 输入
 * 3
 * 返回值
 * 4
 */
public class JZ09 {
    public static void main(String[] args) {
        JZ09 jz09 = new JZ09();
        int res = jz09.JumpFloorII(3);
        System.out.println(res);
    }

    public int JumpFloorII(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 1;
        for (int i = 1; i < n; i++) {
            res += JumpFloorII(n - i);
        }
        return res;
    }
}
