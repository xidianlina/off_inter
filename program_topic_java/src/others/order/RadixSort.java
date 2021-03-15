package others.order;

/*
基数排序
基数排序的思想：
把待排序的整数按位分，分为个位，十位，百位.....从小到大依次将位数进行排序。实际上分为两个过程：分配和收集。
分配就是：从个位开始，按位数从小到大把数据排好，分别放进0--9这10个桶中。
收集就是：依次将0-9桶中的数据放进数组中。
重复这两个过程直到最高位。
 */
public class RadixSort {
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        radixSort.printArray(arr);
        radixSort.radixSort(arr, 10);
        radixSort.printArray(arr);
    }

    public void radixSort(int[] arr, int radix) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int p = 1;
        for (int i = 0; i < size; i++) {
            if (arr[i] >= p) {
                p *= radix;
            }
        }

        int[] tmp = new int[size];
        int[] count = new int[radix];
        int d = radix;
        int divide = 1;
        //进行d次排序
        for (int i = 1; i <= d; i++) {
            //每次分配前清空计数器
            for (int j = 0; j < radix; j++) {
                count[j] = 0;
            }

            for (int j = 0; j < size; j++) {
                //统计每个桶中的记录数
                int index = (arr[j] / divide) % radix;
                count[index]++;
            }

            //将各个桶中的数字个数，转化成各个桶中最后一个数字的下标索引, 即将tmp中的位置依次分配给每个桶
            for (int j = 1; j < radix; j++) {
                count[j] = count[j - 1] + count[j];
            }

            //将所有桶中记录依次收集到tmp中
            for (int j = size - 1; j >= 0; j--) {
                int index = (arr[j] / divide) % radix;
                tmp[count[index] - 1] = arr[j];
                count[index]--;
            }

            //将临时数组的内容复制到arr中
            for (int j = 0; j < size; j++) {
                arr[j] = tmp[j];
            }

            divide = divide * radix;
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
