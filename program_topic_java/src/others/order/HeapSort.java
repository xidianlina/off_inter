package others.order;

/*
堆排序
*二叉树的第i层至多有2的（i-1）次方个结点;深度为k的二叉树至多有2的k次 − 1个结点；对任何一棵二叉树T，如果其终端结点数为n0，度为2的结点数为n2，则n0 = n2 + 1。
*满二叉树:一棵深度为k，且有2的(k)次方－1个节点的二叉树 特点：每一层上的结点数都是最大结点数
*若设二叉树的深度为h，除第h层外，其它各层 (1～h-1) 的结点数都达到最大个数，第h层所有的结点都连续集中在最左边，这就是完全二叉树。
*平衡二叉树，又称AVL树。它或是一棵空树，或是具有下列性质的二叉树:它的左子树和右子树都是平衡二叉树，且左子树和右子树的高度之差的绝对值不超过1。
堆排序是指利用堆这种数据结构所设计的一种排序算法。
堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
具体算法描述如下： ①.将初始待排序关键字序列(R1,R2....Rn)构建成大顶堆，此堆为初始的无序区；
②.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,......Rn-1)和新的有序区(Rn),且满足R[1,2...n-1]<=R[n]；
③.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,......Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2....Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        heapSort.printArray(arr);
        heapSort.heapSort(arr);
        heapSort.printArray(arr);
    }

    public void heapSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = size / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(arr, i, size);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustMaxHeap(arr, 0, --size);
        }
    }

    public void adjustMaxHeap(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < size && arr[left] >= arr[largest]) {
            largest = left;
        }

        if (right < size && arr[right] >= arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            adjustMaxHeap(arr, largest, size);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
