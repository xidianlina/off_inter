package algorithm;

public class FindLost {
    public static void main(String[] args) {
        FindLost findLost = new FindLost();
        int arr[] = {1, 2, 3, 5, 9, 7, 8, 6, 4, 11};
        findLost.findLost(arr);
    }

    public void findLost(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < size; ++i) {
            sum1 += arr[i];
            sum2 += i;
        }
        sum2 += size;

        System.out.println((sum2 - sum1 + size + 1));
    }
}
