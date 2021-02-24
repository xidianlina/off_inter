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
