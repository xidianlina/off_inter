排序算法总结：
======

> 排序算法总结：   
  插入排序：直接插入排序，二分（折半）插入排序，希尔排序   
  交换排序：冒泡排序，快速排序    
  选择排序：简单选择排序，堆排序   
  归并排序  
  基数排序  
  计数排序  

![order](http://github.com/xidianlina/off_inter/raw/master/program_topic_go/others/order/order.jpg)

# 一.插入排序

## 1.直接插入排序
```go
package main

import "fmt"

func insert_sort(arr []int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	for i := 1; i < l; i++ {
		k, j := arr[i], i-1
		for j >= 0 && arr[j] > k {
			arr[j+1] = arr[j]
			j--
		}
		arr[j+1] = k
	}
}

func print_arr(arr []int) {
	l := len(arr)
	if arr == nil || l == 0 {
		return
	}

	for i := 0; i < l-1; i++ {
		fmt.Print(arr[i], "\t")
	}

	fmt.Println(arr[l-1])
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	insert_sort(arr)
	print_arr(arr)
}
```

## 2.二分插入排序
```go
package main

import "fmt"

func binary_insert_sort(arr []int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	for i := 1; i < l; i++ {
		k, left, right, mid := arr[i], 0, i-1, 0
		for left <= right {
			mid = (left + right) >> 1
			if k < arr[mid] {
				right = mid - 1
			} else {
				left = mid + 1
			}
		}

		for j := i - 1; j >= left; j-- {
			arr[j+1] = arr[j]
		}
		arr[left] = k
	}
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	binary_insert_sort(arr)
	print_arr(arr)
}

func print_arr(arr []int) {
	l := len(arr)
	if arr == nil || l == 0 {
		return
	}

	for i := 0; i < l-1; i++ {
		fmt.Print(arr[i], "\t")
	}

	fmt.Println(arr[l-1])
}
```

## 3.希尔排序
> 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
  随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。

```go
package main

import "fmt"

func shell_sort(arr []int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	for g := l / 2; g > 0; g /= 2 {
		for i := g; i < l; i++ {
			k, j := arr[i], i
			for j >= g && arr[j-g] > k {
				arr[j] = arr[j-g]
				j -= g
			}
			arr[j] = k
		}
	}
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	shell_sort(arr)
	print_arr(arr)
}

func print_arr(arr []int) {
	l := len(arr)
	if arr == nil || l == 0 {
		return
	}

	for i := 0; i < l-1; i++ {
		fmt.Print(arr[i], "\t")
	}

	fmt.Println(arr[l-1])
}
```

# 二.交换排序
## 1.冒泡排序
> 算法分析：     
  (1)N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数    
  (2)冒泡排序的优点：每进行一趟排序，就会少比较一次，因为每进行一趟排序都会找出一个较大值。
     如上例：第一趟比较之后，排在最后的一个数一定是最大的一个数，第二趟排序的时候，只需要比较除了最后一个数以外的其他的数，
     同样也能找出一个最大的数排在参与第二趟比较的数后面，第三趟比较的时候，只需要比较除了最后两个数以外的其他的数，以此类推……
     也就是说，没进行一趟比较，每一趟少比较一次，一定程度上减少了算法的量。    
  (3)时间复杂度  
     如果我们的数据正序，只需要走一趟即可完成排序。所需的比较次数C和记录移动次数M均达到最小值，即：Cmin=n-1;Mmin=0;所以，冒泡排序最好的时间复杂度为O(n)。  
     如果很不幸我们的数据是反序的，则需要进行n-1趟排序。每趟排序要进行n-i次比较(1≤i≤n-1)，且每次比较都必须移动记录三次来达到交换记录位置。在这种情况下，比较和移动次数均达到最大值：    
  ![order](http://github.com/xidianlina/off_inter/raw/master/program_topic_go/others/order/bubble_sort.jpg)     
  综上所述：冒泡排序总的平均时间复杂度为：O(n2) ,时间复杂度和数据状况无关。

```go
package main

import "fmt"

func bubble_sort(arr []int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	for i := 0; i < l; i++ {
		for j := 0; j < l-i-1; j++ {
			if arr[j+1] < arr[j] {
				arr[j+1] = arr[j] + arr[j+1]
				arr[j] = arr[j+1] - arr[j]
				arr[j+1] = arr[j+1] - arr[j]
			}
		}
	}
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	bubble_sort(arr)
	print_arr(arr)
}

func print_arr(arr []int) {
	l := len(arr)
	if arr == nil || l == 0 {
		return
	}

	for i := 0; i < l-1; i++ {
		fmt.Print(arr[i], "\t")
	}

	fmt.Println(arr[l-1])
}
```

## 2.带哨兵的冒泡排序
## 3.快速排序

# 三.选择排序
## 1.简单选择排序
## 2.堆排序

# 四.归并排序

# 五.基数排序

# 六.计数排序