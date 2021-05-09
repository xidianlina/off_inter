9种排序算法
======
> 排序算法总结：                   
  插入排序：直接插入排序，二分（折半）插入排序，希尔排序               
  交换排序：冒泡排序，快速排序            
  选择排序：简单选择排序，堆排序               
  归并排序              
  基数排序              
  计数排序          
> ![sort](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/sort_algorithm/picture/sort.png)            
# 一.插入排序
## 1.直接插入排序
```java
package sort_algorithm;

/*
直接插入排序
插入排序是一种最简单的排序方法，它的基本思想是将一个记录插入到已经排好序的有序表中，从而得到一个新的、记录数增1的有序表。
在其实现过程使用双层循环，外层循环对除了第一个元素之外的所有元素，内层循环对当前元素前面有序表进行待插入位置查找，并进行移动。
属于稳定的排序，适合于数据量小，部分数据有序的情况排序。
如果目标是把n个元素的序列升序排列，那么采用插入排序存在最好情况和最坏情况。最好情况就是，序列已经是升序排列了，
在这种情况下，需要进行的比较操作需（n-1）次即可。最坏情况是序列是降序排列，那么此时需要进行的比较共有n(n-1)/2次。
插入排序的赋值操作是比较操作的次数加上 (n-1）次。平均来说插入排序算法的时间复杂度为O(n^2。
因而，插入排序不适合对于数据量比较大的排序应用。

平均时间复杂度：O(N^2)
最差时间复杂度：O(N)
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
```
## 2.二分插入排序
```java
package sort_algorithm;

import java.math.BigDecimal;

//二分插入排序
public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
        binaryInsertSort.printArray(arr);
        binaryInsertSort.binaryInsertSort(arr);
        binaryInsertSort.printArray(arr);
    }

    public void binaryInsertSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 1; i < size; ++i) {
            int key = arr[i];
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; --j) {
                arr[j + 1] = arr[j];
            }
            arr[left] = key;
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
```
## 3.希尔排序
```java
package sort_algorithm;

/*
希尔排序
希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序，随着增量逐渐减少，
每组包含的关键词越来越多，当增量减至1时，整个数组恰被分成一组，算法便终止。

平均时间复杂度：O(Nlog2N)
最佳时间复杂度：O(N)
最差时间复杂度：O(N^2)
空间复杂度：O(1)
稳定性：不稳定
复杂性：较复杂
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
```
# 二.交换排序
## 1.冒泡排序
```java
package sort_algorithm;

import java.io.BufferedWriter;

/*
冒泡排序
算法分析：
(1)N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数
(2)冒泡排序的优点：每进行一趟排序，就会少比较一次，因为每进行一趟排序都会找出一个较大值。第一趟比较之后，排在最后的一个数一定是最大的一个数，
第二趟排序的时候，只需要比较除了最后一个数以外的其他的数，同样也能找出一个最大的数排在参与第二趟比较的数后面，第三趟比较的时候，只需要比较除了最后两
个数以外的其他的数，以此类推…… 也就是说，没进行一趟比较，每一趟少比较一次，一定程度上减少了算法的量。
 
平均时间复杂度：O(N^2)
最佳时间复杂度：O(N)
最差时间复杂度：O(N^2)
空间复杂度：O(1)
排序方式：In-place
稳定性：稳定
*/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.printArray(arr);
        bubbleSort.bubbleSort(arr);
        bubbleSort.printArray(arr);
        System.out.println("-----------------");
        int[] arr2 = {3, 8, 0, 5, 7, 9, 1, 4, 2, 6};
        bubbleSort.printArray(arr2);
        bubbleSort.bubbleSort2(arr2);
        bubbleSort.printArray(arr2);
        System.out.println("===================");
        int[] arr3 = {6, 8, 0, 5, 7, 9, 1, 4, 2, 3};
        bubbleSort.printArray(arr3);
        bubbleSort.bubbleSort3(arr3);
        bubbleSort.printArray(arr3);
    }

    public void bubbleSort3(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size; ++i) {
            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < size - i - 1; ++j) {
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

        for (int i = size - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
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

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size - i - 1; ++j) {
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

        for (int i = 0; i < size - 1; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
```
## 2.带哨兵的冒泡排序
```java
package sort_algorithm;

public class BubbleSortWithPosition {
    public static void main(String[] args) {
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        BubbleSortWithPosition bubbleSortWithPosition = new BubbleSortWithPosition();
        bubbleSortWithPosition.printArray(arr);
        bubbleSortWithPosition.bubbleSortWithPosition(arr);
        bubbleSortWithPosition.printArray(arr);
    }

    public void bubbleSortWithPosition(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int i = size - 1;
        while (i > 0) {
            int pos = 0;
            for (int j = 0; j < i; ++j) {
                if (arr[j + 1] < arr[j]) {
                    pos = j;
                    arr[j + 1] = arr[j + 1] + arr[j];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] = arr[j + 1] - arr[j];
                }
            }
            i = pos;
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
```
## 3.快速排序
```java
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

平均时间复杂度：O(NlogN)
最佳时间复杂度：O(NlogN)
最差时间复杂度：O(N^2)
空间复杂度：根据实现方式的不同而不同
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 10, 5, 7, 9, 81, 4, 2, 8, 3};
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
            System.out.println("index " + index);
            printArray(arr);
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

        System.out.println("pivot " + pivot + " low " + low + " arr[low] " + arr[low] + " arr[high] " + arr[high]);
        printArray(arr);

        //跳出循环时low和high相等,此时的low或high就是pivot的正确索引位置,
        //low位置的值并不是pivot,所以需要将pivot赋值给arr[low]
        arr[low] = pivot;
        
        printArray(arr);

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
```
# 三.选择排序
## 1.简单选择排序
```java
package sort_algorithm;

/*
第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，
然后放到已排序的序列的末尾。以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。

平均时间复杂度：O(N^2)
最佳时间复杂度：O(N^2)
最差时间复杂度：O(N^2)
空间复杂度：O(1)
排序方式：In-place
稳定性：不稳定
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {6, 10, 5, 7, 9, 81, 4, 2, 8, 3};
        SelectSort selectSort = new SelectSort();
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
        for (int i = 0; i < size; ++i) {
            minIndex = i;
            for (int j = i; j < size; ++j) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
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
```
## 2.堆排序
```java
package sort_algorithm;

/*
 * 堆排序
 * 二叉树的第i层至多有2的（i-1）次方个结点;深度为k的二叉树至多有2的k次 − 1个结点；
 * 对任何一棵二叉树T，如果其终端结点数为n0，度为2的结点数为n2，则n0=n2+1。
 * 满二叉树:一棵深度为k，且有2的(k)次方－1个节点的二叉树 特点：每一层上的结点数都是最大结点数
 * 若设二叉树的深度为h，除第h层外，其它各层 (1～h-1) 的结点数都达到最大个数，第h层所有的结点都连续集中在最左边，这就是完全二叉树。
 * 平衡二叉树，又称AVL树。它或是一棵空树，或是具有下列性质的二叉树:它的左子树和右子树都是平衡二叉树，且左子树和右子树的高度之差的绝对值不超过1。
 *
 * 堆排序是指利用堆这种数据结构所设计的一种排序算法。
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * 具体算法描述如下：
 * ①.将初始待排序关键字序列(R1,R2....Rn)构建成大顶堆，此堆为初始的无序区；
 * ②.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,......Rn-1)和新的有序区(Rn),且满足R[1,2...n-1]<=R[n]；
 * ③.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,......Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，
 * 得到新的无序区(R1,R2....Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * 平均时间复杂度：O(nlogn)
 * 最佳时间复杂度：O(nlogn)
 * 最差时间复杂度：O(nlogn)
 * 稳定性：不稳定
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {6, 10, 5, 7, 9, 81, 4, 2, 8, 3};
        HeapSort heapSort = new HeapSort();
        heapSort.printArray(arr);
        heapSort.heapSort(arr);
        heapSort.printArray(arr);
    }

    public void heapSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = size / 2 - 1; i >= 0; --i) {
            adjustMaxHeap(arr, i, size);
        }

        for (int i = size - 1; i > 0; --i) {
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

        for (int i = 0; i < size - 1; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
```
# 四.归并排序
```java
package sort_algorithm;

/*
归并排序，是创建在归并操作上的一种有效的排序算法。算法是采用分治法的一个非常典型的应用，且各层分治递归可以同时进行。
归并排序是用分治思想，分治模式在每一层递归上有三个步骤：
分解（Divide）：将n个元素分成两个含n/2个元素的子序列。
解决（Conquer）：用合并排序法对两个子序列递归的排序。
合并（Combine）：合并两个已排序的子序列得到排序结果。

平均时间复杂度：O(nlogn)
最佳时间复杂度：O(nlogn)
最差时间复杂度：O(nlogn)
空间复杂度：O(n)
排序方式：In-place
稳定性：稳定
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 10, 5, 7, 9, 81, 4, 2, 8, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.printArray(arr);
        mergeSort.mergeSort(arr);
        mergeSort.printArray(arr);
    }

    public void mergeSort(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        mergeSortHelper(arr, 0, size - 1);
    }

    private void mergeSortHelper(int[] arr, int low, int high) {
        int mid = (low + high) >> 1;
        if (low < high) {
            mergeSortHelper(arr, low, mid);
            mergeSortHelper(arr, mid + 1, high);
            mergeSortCore(arr, low, mid, high);
        }
    }

    private void mergeSortCore(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = arr[i++];
        }

        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        for (int m = 0; m < tmp.length; ++m) {
            arr[left + m] = tmp[m];
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
```
# 五.基数排序
```java
package sort_algorithm;

/*
基数排序
基数排序的思想：
把待排序的整数按位分，分为个位，十位，百位.....从小到大依次将位数进行排序。实际上分为两个过程：分配和收集。
分配就是：从个位开始，按位数从小到大把数据排好，分别放进0--9这10个桶中。
收集就是：依次将0-9桶中的数据放进数组中。
重复这两个过程直到最高位。

平均时间复杂度：O(d(n+r)) r为基数，d为位数
最佳时间复杂度：O(d(n+r))
最差时间复杂度：O(d(n+r))
稳定性：稳定
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {16, 10, 59, 7, 9345, 81, 400, 2, 890, 39};
        RadixSort radixSort = new RadixSort();
        radixSort.printArray(arr);
        radixSort.radixSort(arr, 10);
        radixSort.printArray(arr);
    }

    public void radixSort(int[] arr, int radix) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int[] tmp = new int[size];
        int[] count = new int[radix];
        int divide = 1;

        //进行radix次排序
        for (int i = 1; i <= radix; i++) {
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

        for (int i = 0; i < size - 1; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
```
# 六.计数排序
```java
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
```
