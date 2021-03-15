package others.order;

import java.lang.reflect.Method;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        mergeSort.printArray(arr);
        mergeSort.mergeSort(arr);
        mergeSort.printArray(arr);
    }

    public void mergeSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        mergeHelper(arr, 0, size - 1);
    }

    public void mergeHelper(int[] arr, int low, int high) {
        int mid = (low + high) >> 1;
        if (low < high) {
            mergeHelper(arr, low, mid);
            mergeHelper(arr, mid + 1, high);
            mergeCore(arr, low, mid, high);
        }
    }

    public void mergeCore(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = arr[i++];
        }

        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        for (int m = 0; m < tmp.length; m++) {
            arr[left + m] = tmp[m];
        }
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
