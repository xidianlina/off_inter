package sort_algorithm;

/*
归并排序，是创建在归并操作上的一种有效的排序算法。算法是采用分治法的一个非常典型的应用，且各层分治递归可以同时进行。
归并排序是用分治思想，分治模式在每一层递归上有三个步骤：
分解（Divide）：将n个元素分成两个含n/2个元素的子序列。
解决（Conquer）：用合并排序法对两个子序列递归的排序。
合并（Combine）：合并两个已排序的子序列得到排序结果。

平均时间复杂度：O(nlogn)
最佳时间复杂度：O(nlogn)
最差时间复杂度：O(nlogn)
空间复杂度：O(n)
排序方式：In-place
稳定性：稳定
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 10, 5, 7, 9, 81, 4, 2, 8, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.printArray(arr);
        mergeSort.mergeSort(arr);
        mergeSort.printArray(arr);
    }

    public void mergeSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        mergeSortHelper(arr, 0, size - 1);
    }

    private void mergeSortHelper(int[] arr, int low, int high) {
        int mid = (low + high) >> 1;
        if (low < high) {
            mergeSortHelper(arr, low, mid);
            mergeSortHelper(arr, mid + 1, high);
            mergeSortCore(arr, low, mid, high);
        }
    }

    private void mergeSortCore(int[] arr, int left, int mid, int right) {
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

        for (int m = 0; m < tmp.length; ++m) {
            arr[left + m] = tmp[m];
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
