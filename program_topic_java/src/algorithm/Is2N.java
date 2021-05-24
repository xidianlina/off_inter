package algorithm;

//凡是2的N次方的整数，其二进制码只有一个1
public class Is2N {
    public static void main(String[] args) {
        boolean flag = is2N(34);
        System.out.println(flag);
    }

    public static boolean is2N(int n) {
        if (n > 0 && (n & (n - 1)) == 0) {
            return true;
        }

        return false;
    }
}
