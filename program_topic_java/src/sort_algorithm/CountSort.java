package sort_algorithm;

/*
计数排序是一种稳定的线性时间排序算法。
基本思想
计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。
计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

用来计数的数组C的长度取决于待排序数组中数据的范围（等于待排序数组的最大值与最小值的差加上1），然后进行分配、收集处理：
① 分配。扫描一遍原始数组，以当前值-minValue作为下标，将该下标的计数器增1。
② 收集。扫描一遍计数器数组，按顺序把值收集起来。

实现逻辑
① 找出待排序的数组中最大和最小的元素
② 统计数组中每个值为i的元素出现的次数，存入数组C的第i项
③ 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
④ 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1

平均时间复杂度：O(n)
最佳时间复杂度：O(n)
最差时间复杂度：O(n)
空间复杂度：O(n)
 */
public class CountSort {
    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        countSort.printArray(arr);
        int[] res = countSort.countSort(arr);
        countSort.printArray(res);
    }

    public int[] countSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return new int[]{};
        }

        int maxInt = Integer.MIN_VALUE;
        int minInt = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            if (arr[i] > maxInt) {
                maxInt = arr[i];
            }
            if (arr[i] < minInt) {
                minInt = arr[i];
            }
        }

        int[] helperArr = new int[maxInt - minInt + 1];
        for (int i = 0; i < size; i++) {
            int pos = arr[i - minInt];
            helperArr[pos]++;
        }

        for (int i = 1; i < size; i++) {
            //确定不比该位置大的数据个数,不比它大的数据个数为它的个数加上前一个的记数。
            helperArr[i] = helperArr[i - 1] + helperArr[i];
        }

        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            //为什么要先减一，因为保存不比它大数据的个数中包括了它自己，所以要先减一
            helperArr[arr[i] - minInt]--;
            int pos = helperArr[arr[i] - minInt];
            res[pos] = arr[i];
        }

        return res;
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
