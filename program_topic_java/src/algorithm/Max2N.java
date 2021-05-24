package algorithm;

public class Max2N {
    public static void main(String[] args) {
        System.out.println(max2N(17));
        System.out.println(max2N(31));
    }

    public static int max2N(int n) {
        if ((n > 0) && (n & (n - 1)) == 0) {
            return n;
        }

        return max2N(n - 1);
    }
}
