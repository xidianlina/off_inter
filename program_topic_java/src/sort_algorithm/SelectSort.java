package sort_algorithm;

/*
第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，
然后放到已排序的序列的末尾。以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。

平均时间复杂度：O(N^2)
最佳时间复杂度：O(N^2)
最差时间复杂度：O(N^2)
空间复杂度：O(1)
排序方式：In-place
稳定性：不稳定
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {6, 10, 5, 7, 9, 81, 4, 2, 8, 3};
        SelectSort selectSort = new SelectSort();
        selectSort.printArray(arr);
        selectSort.selectSort(arr);
        selectSort.printArray(arr);
    }

    public void selectSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int minIndex = 0;
        int tmp = 0;
        for (int i = 0; i < size; ++i) {
            minIndex = i;
            for (int j = i; j < size; ++j) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
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
