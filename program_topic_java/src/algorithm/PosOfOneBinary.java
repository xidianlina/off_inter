package algorithm;

public class PosOfOneBinary {
    public static void main(String[] args) {
        System.out.println(posOfOneBinary(3));
    }

    /*
        这个问题实际上等同于求N!含有质因数2的个数+1。即答案等于N!含有质因数2的个数加1。
        如果一个质数是某个数的因数，那么就说这个质数是这个数的质因数。因为每存在一个2，则在数的最低位多1个0。
        实际上N！都为偶数，因为质因数里面都有一个2，除了1以外，因为1的阶乘是1，是个奇数，其他数的阶乘都是偶数。
     */
    public static int posOfOneBinary(int n) {
        if (n < 0) {
            return -1;
        }

        int res = 0;
        while (n != 0) {
            n >>= 1;
            res += n;
        }

        return (res + 1);
    }
}
