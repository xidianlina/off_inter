package algorithm;

public class LastThree {
    public static void main(String[] args) {
        LastThree lt = new LastThree();
        int res = lt.lastThree(23, 9);
        System.out.println(res);
    }

    private int lastThree(int n, int m) {
        int last = 1;
        for (int i = 1; i <= m; ++i) {
            last = (last * n) % 1000;
        }
        return last;
    }
}
