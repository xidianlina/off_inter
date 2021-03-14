package others.order;

//二分插入排序
public class BinaryInsertSort {
    public static void main(String[] args) {
        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        binaryInsertSort.printArray(arr);
        binaryInsertSort.binaryInsertSort(arr);
        binaryInsertSort.printArray(arr);
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

    public void binaryInsertSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 1; i < size; i++) {
            int k = arr[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (arr[mid] > k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }
            arr[left] = k;
        }
    }
}
