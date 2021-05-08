package sort_algorithm;

/*
通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
快速排序算法通过多次比较和交换来实现排序，其排序流程如下:
(1)首先设定一个分界值，通过该分界值将数组分成左右两部分。
(2)将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。
此时，左边部分中各元素都小于或等于分界值，而右边部分中各元素都大于或等于分界值。
(3)然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，
同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
(4)重复上述过程。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左、右两个部分各数据排序完成后，整个数组的排序也就完成了。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.printArray(arr);
        quickSort.quickSort(arr);
        quickSort.printArray(arr);
    }

    public void quickSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        quickSortHelper(arr, 0, size - 1);
    }

    private void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = partition(arr, low, high);
            quickSortHelper(arr, low, index - 1);
            quickSortHelper(arr, index + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        //基准数据
        int pivot = arr[low];
        while (low < high) {

            //当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= pivot) {
                --high;
            }

            //如果队尾元素小于pivot了,需要将其赋值给low
            arr[low] = arr[high];

            //当队首元素小于等于pivot时,向前挪动low指针
            while (low < high && arr[low] <= pivot) {
                ++low;
            }

            //当队首元素大于pivot时,需要将其赋值给high
            arr[high] = arr[low];
        }

        //跳出循环时low和high相等,此时的low或high就是pivot的正确索引位置,
        //low位置的值并不是pivot,所以需要将pivot赋值给arr[low]
        arr[low] = pivot;

        // 返回pivot的正确位置
        return low;
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
