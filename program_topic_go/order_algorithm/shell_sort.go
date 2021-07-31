package main

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
