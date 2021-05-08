9种排序算法
======
> 排序算法总结：                   
  插入排序：直接插入排序，二分（折半）插入排序，希尔排序               
  交换排序：冒泡排序，快速排序            
  选择排序：简单选择排序，堆排序               
  归并排序              
  基数排序              
  计数排序          
> ![sort](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/sort_algorithm/picture/kmp.png)            
# 插入排序
## 直接插入排序
```java
package others.order;

//直接插入排序
public class InsertSort {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        insertSort.printArray(arr);

        insertSort.insertSort(arr);
        insertSort.printArray(arr);
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
}
```
## 二分插入排序