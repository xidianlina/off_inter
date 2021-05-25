package algorithm;

public class RecurSum {
    public static void main(String[] args) {
        RecurSum r = new RecurSum();
        int[] arr = {9, 3, 1, 5, 2};
        int sum = r.recurSum(arr, arr.length);
        System.out.println(sum);
    }

    public int recurSum(int[] arr, int n) {
        if (n == 0 || arr == null) {
            return 0;
        }

        return recurSum(arr, n - 1) + arr[n - 1];
    }
}
