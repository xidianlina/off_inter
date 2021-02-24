package main

func radix_sort(arr []int, radix int) {
	l := len(arr)
	if l == 0 || arr == nil {
		return
	}

	d, p := 1, radix
	for i := 0; i < l; i++ {
		for arr[i] >= p {
			p *= radix
		}
	}

	tmp, count, divide := make([]int, l), make([]int, radix), 1
	//进行d次排序
	for i := 1; i <= d; i++ {
		//每次分配前清空计数器
		for j := 0; j < radix; j++ {
			count[j] = 0
		}

		for j := 0; j < l; j++ {
			//统计每个桶中的记录数
			idx := (arr[j] / divide) % radix
			count[idx]++
		}

		//将各个桶中的数字个数，转化成各个桶中最后一个数字的下标索引, 即将tmp中的位置依次分配给每个桶
		for j := 1; j < radix; j++ {
			count[j] = count[j-1] + count[j]
		}

		//将所有桶中记录依次收集到tmp中
		for j := l - 1; j >= 0; j-- {
			idx := (arr[j] / divide) % radix
			tmp[count[idx]-1] = arr[j]
			count[idx]--
		}

		//将临时数组的内容复制到arr中
		for j := 0; j < l; j++ {
			arr[j] = tmp[j]
		}

		divide = divide * radix
	}
}

func main() {
	arr := []int{7, 0, 1, 9, 4, 6, 3, 5, 2, 8}
	print_arr(arr)
	radix_sort(arr, 10)
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
