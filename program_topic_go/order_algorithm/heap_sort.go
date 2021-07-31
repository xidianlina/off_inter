package main

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
