package sort_algorithm;

/*
直接插入排序
插入排序是一种最简单的排序方法，它的基本思想是将一个记录插入到已经排好序的有序表中，从而得到一个新的、记录数增1的有序表。
在其实现过程使用双层循环，外层循环对除了第一个元素之外的所有元素，内层循环对当前元素前面有序表进行待插入位置查找，并进行移动。
属于稳定的排序，适合于数据量小，部分数据有序的情况排序。
如果目标是把n个元素的序列升序排列，那么采用插入排序存在最好情况和最坏情况。最好情况就是，序列已经是升序排列了，
在这种情况下，需要进行的比较操作需（n-1）次即可。最坏情况是序列是降序排列，那么此时需要进行的比较共有n(n-1)/2次。
插入排序的赋值操作是比较操作的次数加上 (n-1）次。平均来说插入排序算法的时间复杂度为O(n^2)。
因而，插入排序不适合对于数据量比较大的排序应用。

平均时间复杂度：O(N^2)
最好时间复杂度：O(N)
最差时间复杂度：O(N^2)
空间复杂度：O(1)
排序方式：In-place
稳定性：稳定
 */
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
