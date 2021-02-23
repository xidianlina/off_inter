package main

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

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	insert_sort(arr)
	print_arr(arr)
}
