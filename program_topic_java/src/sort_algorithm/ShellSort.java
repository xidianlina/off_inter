package sort_algorithm;

/*
希尔排序
希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序，随着增量逐渐减少，
每组包含的关键词越来越多，当增量减至1时，整个数组恰被分成一组，算法便终止。
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        ShellSort shellSort = new ShellSort();
        shellSort.printArray(arr);
        shellSort.shellSort(arr);
        shellSort.printArray(arr);
    }

    public void shellSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int group = size / 2; group > 0; group /= 2) {
            for (int i = group; i < size; ++i) {
                int k = arr[i];
                int j = i;
                while (j >= group && arr[j - group] > k) {
                    arr[j] = arr[j - group];
                    j -= group;
                }
                arr[j] = k;
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
