package others.order;

/*
冒泡排序
算法分析：
(1)N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数
(2)冒泡排序的优点：每进行一趟排序，就会少比较一次，因为每进行一趟排序都会找出一个较大值。 如上例：第一趟比较之后，排在最后的一个数一定是最大的一个数，
第二趟排序的时候，只需要比较除了最后一个数以外的其他的数， 同样也能找出一个最大的数排在参与第二趟比较的数后面，第三趟比较的时候，只需要比较除了最后两
个数以外的其他的数，以此类推…… 也就是说，没进行一趟比较，每一趟少比较一次，一定程度上减少了算法的量。
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        bubbleSort.printArray(arr);
        bubbleSort.bubbleSort(arr);
        bubbleSort.printArray(arr);

        int[] arr2 = {8, 5, 7, 9, 1, 4, 2, 6, 3};
        bubbleSort.printArray(arr2);
        bubbleSort.bubbleSort2(arr2);
        bubbleSort.printArray(arr2);

        int[] arr3 = {0, 8, 5, 7, 9, 1, 4, 2, 6, 3};
        bubbleSort.printArray(arr3);
        bubbleSort.bubbleSort3(arr3);
        bubbleSort.printArray(arr3);
    }

    public void bubbleSort3(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size; i++) {
            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }

    public void bubbleSort2(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    arr[j + 1] = arr[j + 1] + arr[j];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] = arr[j + 1] - arr[j];
                }
            }
        }
    }

    public void bubbleSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    arr[j + 1] = arr[j + 1] + arr[j];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] = arr[j + 1] - arr[j];
                }
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
