package main

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
