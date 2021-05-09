package sword_offer;

/**
 * 题目描述:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class JZ10 {
    public static void main(String[] args) {
        JZ10 jz10 = new JZ10();
        int res = jz10.RectCover(4);
        System.out.println(res);
    }

    public int RectCover(int n) {
        if (n <= 2) {
            return n;
        }
        return RectCover(n - 1) + RectCover(n - 2);
    }

    public int RectCover2(int n) {
        if (n <= 1) {
            return n;
        }

        int tmp = 0, pre = 1, res = 1;
        for (int i = 2; i <= n; ++i) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }

        return res;
    }
}
