package sort_algorithm;

//直接插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        InsertSort insertSort = new InsertSort();
        insertSort.printArray(arr);
        insertSort.insertSort(arr);
        insertSort.printArray(arr);
    }

    public void insertSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 1; i < size; ++i) {
            int k = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = k;
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
