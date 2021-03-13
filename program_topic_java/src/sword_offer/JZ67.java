package sword_offer;

/**
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 返回值描述:
 * 输出答案。
 * 示例1
 * 输入
 * 8
 * 返回值
 * 18
 */
public class JZ67 {
    /*
    解题思路
    首先判断k[0]到k[m]可能有哪些数字，实际上只可能是2或者3。
    当然也可能有4，但是4=2*2，所以简单些不考虑了。
    5<2*3,6<3*3,比6更大的数字就更不用考虑了，肯定要继续分。
    其次看2和3的数量，2的数量肯定小于3个，为什么呢？
    因为2*2*2<3*3，那么题目就简单了。
    直接用n除以3，根据得到的余数判断是一个2还是两个2还是没有2就行了。
    由于题目规定m>1，所以2只能是1*1，3只能是2*1，这两个特殊情况直接返回就行了。
     */
    public int cutRope(int target) {
        if (target < 3) {
            return target - 1;
        }

        int x = target % 3, y = target / 3;
        if (x == 0) {
            return pow_helper(3, y);
        } else if (x == 1) {
            return 2 * 2 * pow_helper(3, y - 1);
        } else {
            return 2 * pow_helper(3, y);
        }
    }

    private int pow_helper(int n, int m) {
        if (m == 0) {
            return 1;
        }
        int res = n;
        for (int i = 1; i < m; i++) {
            res *= n;
        }

        return res;
    }
}
