package others.order;

//快速排序
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
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

    public void quickSortHelper(int[] arr, int low, int high) {
        int pivot = 0;
        if (low < high) {
            pivot = partition(arr, low, high);
            quickSortHelper(arr, low, pivot - 1);
            quickSortHelper(arr, pivot + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
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

        for (int i = 0; i < size - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
