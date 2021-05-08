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

//直接插入排序
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

# 三.选择排序
## 1.简单选择排序
## 2.堆排序
# 四.归并排序
# 五.基数排序
# 六.计数排序




