package algorithm;

public class Divide {
    public static void main(String[] args) {
        divide(10, 3);
        divide2(10, 3);
    }

    public static void divide(int a, int b) {
        for (int i = 2; i < a; ++i) {
            if (i * b > a) {
                System.out.println((i - 1) + " " + (a - (i - 1) * b));
                break;
            }
        }
    }

    public static void divide2(int a, int b) {
        int i = 1;
        while ((a - b) > b) {
            a = a - b;
            ++i;
        }

        System.out.println(i + " " + (a - b));
    }
}
