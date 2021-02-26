package main

import "fmt"

func shuffle(arr []int) {
	l := len(arr)
	if l < 3 || l%2 == 1 {
		return
	}

	size, index, count := l/2, 0, 0
	for i := size; i < l-1; i++ {
		count = size - (i - size) - 1 //交换个数
		index = i                     //待交换的数的下标
		for j := 1; j <= count; j++ {
			arr[index], arr[i-j] = arr[i-j], arr[index]
			index = i - j
		}
	}
}

func shuffle2(arr []int) {
	l := len(arr)
	if l < 3 || l%2 == 1 {
		return
	}

	n := l / 2
	left, right := n-1, n
	// 交换次数
	for i := 0; i < n-1; i++ {
		for j := left; j < right; j += 2 {
			arr[j], arr[j+1] = arr[j+1], arr[j]
		}
		left--
		right++
	}
}

func shuffle3(arr []int) {
	l := len(arr)
	if l < 3 || l%2 == 1 {
		return
	}

	res := make([]int, l)
	for i := 1; i < l-1; i++ {
		res[(2*i)%(l-1)] = arr[i]
	}

	for j := 1; j < l-1; j++ {
		arr[j] = res[j]
	}
}

func main() {
	arr := []int{0, 2, 4, 6, 8, 1, 3, 5, 7, 9}
	shuffle(arr)
	fmt.Println(arr)
	fmt.Println("------------")
	arr2 := []int{0, 2, 4, 6, 8, 1, 3, 5, 7, 9}
	shuffle2(arr2)
	fmt.Println(arr2)
	fmt.Println("------------")
	arr3 := []int{0, 2, 4, 6, 8, 1, 3, 5, 7, 9}
	shuffle3(arr3)
	fmt.Println(arr3)
}
