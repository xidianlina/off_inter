package algorithm;

public class SumWithRecur {
    public static void main(String[] args) {
        SumWithRecur sumWithRecur = new SumWithRecur();
        int sum = sumWithRecur.sumWithRecur(5);
        System.out.println(sum);
    }

    public int sumWithRecur(int n) {
        if (n == 1) {
            return 1;
        }

        return sumWithRecur(n - 1) + n;
    }
}
