package others.order;

//计数排序
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
