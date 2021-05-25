package algorithm;

/*
如何判断一个整数x是否可以表示成 n（n >= 2）个连续正整数的和。
分析：假设x可以表示成n（n >= 2）个连续正整数的和，那么x = m + (m + 1) + (m + 2) + … + (m + n - 1)，
其中m为分解成的连续整数中最小的那一个（且 m 是大于等于 1 的正整数），可推出 x = (2m + n - 1)*n/2，
变换之后 m = (2*x/n - n + 1)/2；由 m 的取值范围可知 (2*x/n - n + 1)/2 >= 1，又因为m是正整数，
所以(2*x/n - n + 1) 一定要为偶数；否则m = (2*x/n - n + 1)/2 就是小数，不符合要求；
（注意：(2*x/n - n + 1) 看成是 float 类型的）。给定一个 n，看 x 是否能分解成 n 个连续整数的和，
可以判断是否存在 m，也就是 (2*x/n - n + 1) 是否是偶数的问题。
 */
public class ContinuousSequence {
    public static void main(String[] args) {
        findContinuousSequence(32, 5);
    }

    public static void findContinuousSequence(int x, int n) {
        float tmp = (float) 2 * x / n - (float) (n - 1);
        int m = (int) tmp / 2;
        if ((int) tmp % 2 == 0 && m >= 1) {
            System.out.print("x可分解为: ");
            int start = m;
            int end = m + n - 1;
            while (start <= end) {
                System.out.print(start + "\t");
                ++start;
            }
            System.out.println();
        } else {
            System.out.println("x不可分解");
        }
    }
}
