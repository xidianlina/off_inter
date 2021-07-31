package main

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
