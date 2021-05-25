package algorithm;

public class FindBalance {
    public static void main(String[] args) {
        FindBalance fb = new FindBalance();
        int[] arr = {5, 1, -1, 3, 2, 7, -3, 0, 4};
        fb.findBalance(arr);
    }

    public void findBalance(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int sum = 0;
        int subSum = 0;
        for (int i = 0; i < size; ++i) {
            sum += arr[i];
        }

        for (int i = 0; i < size; ++i) {
            if (subSum == (sum - subSum - arr[i])) {
                System.out.println("balance is " + arr[i]);
            } else {
                subSum += arr[i];
            }
        }
    }
}
