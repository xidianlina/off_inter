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
	arr := []int{-1, 0, 2, 4, 6, 8, 1, 3, 5, 7, 9}
	perfect_shuffle(arr)
	fmt.Println(arr)
}

//完美洗牌算法
func perfect_shuffle(arr []int) {
	l := len(arr)
	n := (l - 1) / 2
	start := 0

	for n > 1 {
		//第1步：找到2*m = 3^k - 1，使得3^k <= len - 1 < 3^(k + 1)
		k, m := 0, 1

		//for (; (len - 1) / m >= 3; k++, m = m * 3) ;
		for (l-1)/m >= 3 {
			k++
			m = m * 3
		}

		m = m / 2

		//第2步：把数组中的A[m + 1,...,n + m]那部分循环右移m位
		right_rotate(arr, start, m, n)

		//第3步：对于长度为2*m的数组，刚好有k个圈，每个圈的头部为3^i
		i, t := 0, 1
		for i < k {
			cycle_leader(arr, t, m*2+1)
			i++
			t = t * 3
		}

		//第4步：对数组后面部分A[2m + 1,...,2n]继续递归上面3步
		start = start + m*2
		n = n - m
	}

	//n == 1时
	arr[1+start], arr[2+start] = arr[2+start], arr[1+start]
	for i := 1; i < l; i = i + 2 {
		arr[i], arr[i+1] = arr[i+1], arr[i]
	}
}

// 走圈算法
func cycle_leader(arr []int, start, mod int) {
	for i := start * 2 % mod; i != start; i = i * 2 % mod {
		arr[i], arr[start] = arr[start], arr[i]
	}
}

//翻转 start 开始位置 end 结束位置
func reverse(arr []int, start, end int) {
	for start < end {
		arr[start], arr[end] = arr[end], arr[start]
		start++
		end--
	}
}

func right_rotate(arr []int, start, m, n int) {
	//翻转前m位
	reverse(arr, start+m+1, start+n)

	//翻转剩余元素
	reverse(arr, start+n+1, start+n+m)

	//整体翻转
	reverse(arr, start+m+1, start+n+m)
}

//func main() {
//	arr := []int{0, 2, 4, 6, 8, 1, 3, 5, 7, 9}
//	shuffle(arr)
//	fmt.Println(arr)
//	fmt.Println("------------")
//	arr2 := []int{0, 2, 4, 6, 8, 1, 3, 5, 7, 9}
//	shuffle2(arr2)
//	fmt.Println(arr2)
//	fmt.Println("------------")
//	arr3 := []int{0, 2, 4, 6, 8, 1, 3, 5, 7, 9}
//	shuffle3(arr3)
//	fmt.Println(arr3)
//	fmt.Println("------------")
//	arr4 := []int{-1, 0, 2, 4, 6, 8, 1, 3, 5, 7, 9}
//	perfect_shuffle(arr4)
//	fmt.Println(arr4)
//}
