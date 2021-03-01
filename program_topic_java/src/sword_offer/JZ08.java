package sword_offer;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 示例1
 * 输入
 * 1
 * 返回值
 * 1
 * 示例2
 * 输入
 * 4
 * 返回值
 * 5
 */
public class JZ08 {
    public static void main(String args[]) {
        JZ08 jz08 = new JZ08();
        int res = jz08.JumpFloor(4);
        System.out.println(res);
        int res2 = jz08.JumpFloor2(4);
        System.out.println(res2);
    }

    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloor2(int target) {
        if (target == 1) {
            return target;
        }
        int temp = 0, pre = 1, res = 1;
        for (int i = 2; i <= target; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }

        return res;
    }
}
