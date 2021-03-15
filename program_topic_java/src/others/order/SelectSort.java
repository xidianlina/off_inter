package others.order;

//简单选择排序
public class SelectSort {
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
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
        for (int i = 0; i < size; i++) {
            minIndex = i;
            for (int j = i; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
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
