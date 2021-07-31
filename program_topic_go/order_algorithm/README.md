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
> 每一趟排序都使有序区增加了一个气泡，在经过n-1趟排序之后，有序区中就有n-1个气泡，
  而无序区中气泡的重量总是大于等于有序区中气泡的重量，所以整个冒泡排序过程至多需要
  进行n-1趟排序。若在某一趟排序中未发现气泡位置的交换，则说明待排序的无序区中所有
  气泡均满足轻者在上，重者在下的原则，因此，冒泡排序过程可在此趟排序后终止。
```go
package main

import "fmt"

/**
每一趟排序都使有序区增加了一个气泡，在经过n-1趟排序之后，有序区中就有n-1个气泡，
而无序区中气泡的重量总是大于等于有序区中气泡的重量，所以整个冒泡排序过程至多需要
进行n-1趟排序。若在某一趟排序中未发现气泡位置的交换，则说明待排序的无序区中所有
气泡均满足轻者在上，重者在下的原则，因此，冒泡排序过程可在此趟排序后终止。
*/
func bubble_sort_pos(arr []int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	i := l - 1
	for i > 0 {
		pos := 0
		for j := 0; j < i; j++ {
			if arr[j+1] < arr[j] {
				pos = j
				arr[j+1] = arr[j+1] + arr[j]
				arr[j] = arr[j+1] - arr[j]
				arr[j+1] = arr[j+1] - arr[j]
			}
		}
		i = pos
	}
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	bubble_sort_pos(arr)
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

## 3.快速排序
```go
package main

import "fmt"

func quick_sort(arr []int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	quick_sort_helper(arr, 0, l-1)
}

func quick_sort_helper(arr []int, low, high int) {
	pivot := 0
	if low < high {
		pivot = partition(arr, low, high)
		quick_sort_helper(arr, low, pivot-1)
		quick_sort_helper(arr, pivot+1, high)
	}
}

func partition(arr []int, low, high int) int {
	//基准数据
	pivot := arr[low]

	for low < high {
		//当队尾的元素大于等于基准数据时,向前挪动high指针
		for low < high && arr[high] >= pivot {
			high--
		}

		//如果队尾元素小于pivot了,需要将其赋值给low
		arr[low] = arr[high]

		//当队首元素小于等于pivot时,向前挪动low指针
		for low < high && arr[low] <= pivot {
			low++
		}

		//当队首元素大于pivot时,需要将其赋值给high
		arr[high] = arr[low]
	}

	//跳出循环时low和high相等,此时的low或high就是pivot的正确索引位置,
	//low位置的值并不是pivot,所以需要将pivot赋值给arr[low]
	arr[low] = pivot

	// 返回pivot的正确位置
	return low
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	quick_sort(arr)
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

# 三.选择排序
## 1.简单选择排序
```go
package main

import "fmt"

func select_sort(arr []int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	min_index, tmp := 0, 0
	for i := 0; i < l; i++ {
		min_index = i
		for j := i; j < l; j++ {
			if arr[min_index] > arr[j] {
				min_index = j
			}
		}

		if min_index != i {
			tmp = arr[min_index]
			arr[min_index] = arr[i]
			arr[i] = tmp
		}
	}
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	select_sort(arr)
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

## 2.堆排序
> *二叉树的第i层至多有2的（i-1）次方个结点;深度为k的二叉树至多有2的k次 − 1个结点；对任何一棵二叉树T，如果其终端结点数为n0，度为2的结点数为n2，则n0 = n2 + 1。          
  *满二叉树:一棵深度为k，且有2的(k)次方－1个节点的二叉树 特点：每一层上的结点数都是最大结点数     
  *若设二叉树的深度为h，除第h层外，其它各层 (1～h-1) 的结点数都达到最大个数，第h层所有的结点都连续集中在最左边，这就是完全二叉树。        
  *平衡二叉树，又称AVL树。它或是一棵空树，或是具有下列性质的二叉树:它的左子树和右子树都是平衡二叉树，且左子树和右子树的高度之差的绝对值不超过1。        
  堆排序是指利用堆这种数据结构所设计的一种排序算法。     
  堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。     
  具体算法描述如下：
  ①.将初始待排序关键字序列(R1,R2....Rn)构建成大顶堆，此堆为初始的无序区；       
  ②.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,......Rn-1)和新的有序区(Rn),且满足R[1,2...n-1]<=R[n]；     
  ③.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,......Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2....Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。

```go
package main

import "fmt"

func heap_sort(arr []int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	for i := l/2 - 1; i >= 0; i-- {
		adjustMaxHeap(arr, i, l)
	}

	for i := l - 1; i > 0; i-- {
		swap_ele(arr, 0, i)
		l--
		adjustMaxHeap(arr, 0, l)
	}
}

func adjustMaxHeap(arr []int, i, size int) {
	left, right, largest := 2*i+1, 2*i+2, i
	if left < size && arr[left] >= arr[largest] {
		largest = left
	}
	if right < size && arr[right] >= arr[largest] {
		largest = right
	}
	if largest != i {
		swap_ele(arr, largest, i)
		adjustMaxHeap(arr, largest, size)
	}
}

func swap_ele(arr []int, i, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	heap_sort(arr)
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

# 四.归并排序
```go
package main

import "fmt"

func merge_sort(arr []int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	merge_helper(arr, 0, l-1)
}

func merge_helper(arr []int, low, high int) {
	mid := (low + high) >> 1
	if low < high {
		merge_helper(arr, low, mid)
		merge_helper(arr, mid+1, high)
		merge_core(arr, low, mid, high)
	}
}

func merge_core(arr []int, left, mid, right int) {
	tmp := make([]int, right-left+1)
	i, j, k := left, mid+1, 0
	for i <= mid && j <= right {
		if arr[i] < arr[j] {
			tmp[k] = arr[i]
			i++
		} else {
			tmp[k] = arr[j]
			j++
		}
		k++
	}

	for i <= mid {
		tmp[k] = arr[i]
		k++
		i++
	}

	for j <= right {
		tmp[k] = arr[j]
		k++
		j++
	}

	for m := 0; m < len(tmp); m++ {
		arr[left+m] = tmp[m]
	}
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	merge_sort(arr)
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

# 五.基数排序
> 基数排序的思想：      
  把待排序的整数按位分，分为个位，十位，百位.....从小到大依次将位数进行排序。实际上分为两个过程：分配和收集。      
  分配就是：从个位开始，按位数从小到大把数据排好，分别放进0--9这10个桶中。       
  收集就是：依次将0-9桶中的数据放进数组中。        
  重复这两个过程直到最高位。     
```go
package main

import "fmt"

func radix_sort(arr []int, radix int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	d, p := 1, radix
	for i := 0; i < l; i++ {
		for arr[i] >= p {
			p *= radix
		}
	}

	tmp, count, divide := make([]int, l), make([]int, radix), 1
	//进行d次排序
	for i := 1; i <= d; i++ {
		//每次分配前清空计数器
		for j := 0; j < radix; j++ {
			count[j] = 0
		}

		for j := 0; j < l; j++ {
			//统计每个桶中的记录数
			idx := (arr[j] / divide) % radix
			count[idx]++
		}

		//将各个桶中的数字个数，转化成各个桶中最后一个数字的下标索引, 即将tmp中的位置依次分配给每个桶
		for j := 1; j < radix; j++ {
			count[j] = count[j-1] + count[j]
		}

		//将所有桶中记录依次收集到tmp中
		for j := l - 1; j >= 0; j-- {
			idx := (arr[j] / divide) % radix
			tmp[count[idx]-1] = arr[j]
			count[idx]--
		}

		//将临时数组的内容复制到arr中
		for j := 0; j < l; j++ {
			arr[j] = tmp[j]
		}

		divide = divide * radix
	}
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	radix_sort(arr, 10)
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

# 六.计数排序
```go
package main

import "fmt"

func count_sort(arr []int) []int {
	l := len(arr)
	if l == 0 || arr == nil {
		return arr
	}

	max_int, min_int := ^(int(^uint32((0)) >> 1)), int(^uint32((0))>>1)
	fmt.Println(max_int, min_int)

	for i := 0; i < l; i++ {
		if arr[i] > max_int {
			max_int = arr[i]
		}
		if arr[i] < min_int {
			min_int = arr[i]
		}
	}

	help_arr := make([]int, max_int-min_int+1)
	for i := 0; i < l; i++ {
		pos := arr[i-min_int]
		help_arr[pos]++
	}

	for i := 1; i < l; i++ {
		//确定不比该位置大的数据个数,不比它大的数据个数为它的个数加上前一个的记数。
		help_arr[i] = help_arr[i-1] + help_arr[i]
	}

	res := make([]int, l)
	for i := 0; i < l; i++ {
		//为什么要先减一，因为保存不比它大数据的个数中包括了它自己，所以要先减一
		help_arr[arr[i]-min_int]--
		pos := help_arr[arr[i]-min_int]
		res[pos] = arr[i]
	}

	return res
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	res := count_sort(arr)
	print_arr(res)
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