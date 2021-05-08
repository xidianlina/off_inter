package sort_algorithm;

import java.math.BigDecimal;

//二分插入排序
public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
        binaryInsertSort.printArray(arr);
        binaryInsertSort.binaryInsertSort(arr);
        binaryInsertSort.printArray(arr);
    }

    public void binaryInsertSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 1; i < size; ++i) {
            int key = arr[i];
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; --j) {
                arr[j + 1] = arr[j];
            }
            arr[left] = key;
        }
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size - 1; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
