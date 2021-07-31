package main

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
