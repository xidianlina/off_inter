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
}
