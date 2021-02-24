package main

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
