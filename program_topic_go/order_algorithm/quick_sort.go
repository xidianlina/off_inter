package main

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

//func print_arr(arr []int) {
//	l := len(arr)
//	if arr == nil || l == 0 {
//		return
//	}
//
//	for i := 0; i < l-1; i++ {
//		fmt.Print(arr[i], "\t")
//	}
//
//	fmt.Println(arr[l-1])
//}
