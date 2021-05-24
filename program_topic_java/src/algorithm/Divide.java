package algorithm;

public class Divide {
    public static void main(String[] args) {
        divide(10, 3);
    }

    public static void divide(int a, int b) {
        for (int i = 2; i < a; ++i) {
            if (i * b > a) {
                System.out.println((i - 1) + " " + (a - (i - 1) * b));
                break;
            }
        }
    }
}
