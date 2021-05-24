package algorithm;

public class JieChengHe {
    public static void main(String[] args) {
        System.out.println(jieChengHe(4));
        System.out.println(jieChengHeNoRec(4));
    }

    public static long jieChengHeNoRec(int n) {
        long sum = 0;
        long num = 1;
        for (int i = 1; i <= n; ++i) {
            num *= i;
            sum += num;
        }

        return sum;
    }


    public static long jieChengHe(int n) {
        if (n == 1) {
            return 1;
        }

        return jieChengHe(n - 1) + jieCheng(n);
    }

    public static int jieCheng(int n) {
        if (n == 1) {
            return 1;
        }

        return jieCheng(n - 1) * n;
    }
}
