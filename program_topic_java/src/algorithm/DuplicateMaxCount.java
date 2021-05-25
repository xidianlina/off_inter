package algorithm;

public class DuplicateMaxCount {
    public static void main(String[] args) {
        DuplicateMaxCount maxCount = new DuplicateMaxCount();
        int[] arr = {9, 3, 5, 2, 1, 6, 3, 1, 2, 4, 5, 3, 5};
        int res = maxCount.duplicateMaxCount(arr);
        System.out.println(res);
    }

    public int duplicateMaxCount(int[] arr) {
        int size = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < size; ++i) {
            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int[] helper = new int[max - min + 1];
        for (int i = 0; i < size; ++i) {
            ++helper[arr[i] - min];
        }

        int count = 0;
        int res = 0;
        for (int i = 0; i < size; ++i) {
            if (helper[arr[i] - min] > count) {
                count = helper[arr[i] - min];
                res = arr[i];
            }
        }

        return res;
    }
}
