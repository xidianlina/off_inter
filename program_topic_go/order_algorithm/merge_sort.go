package main

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
