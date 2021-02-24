package main

/**
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

输入描述:
题目保证输入的数组中没有的相同的数字

示例
输入
[1,2,3,4,5,6,7,0]
返回值
7
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param data int整型一维数组
 * @return int整型
 */

var pair_num int

func InversePairs(data []int) int {
	// write code here
	pair_num = 0
	l := len(data)
	if l == 0 || data == nil {
		return 0
	}

	merge_sort(data, 0, l-1)

	return pair_num
}

func merge_sort(arr []int, l, h int) {
	m := (l + h) >> 1
	if l < h {
		merge_sort(arr, l, m)
		merge_sort(arr, m+1, h)
		merge_core(arr, l, m, h)
	}
}

func merge_core(arr []int, left, mid, right int) {
	tmp := make([]int, right-left+1)
	i, j, k := left, mid+1, 0
	for i <= mid && j <= right {
		if arr[i] < arr[j] {
			tmp[k] = arr[i]
			i++
		} else {
			tmp[k] = arr[j]
			j++
			pair_num += mid - i + 1
			if pair_num > 1000000007 {
				pair_num %= 1000000007
			}
		}
		k++
	}

	for i <= mid {
		tmp[k] = arr[i]
		k++
		i++
	}

	for j <= right {
		tmp[k] = arr[j]
		k++
		j++
	}

	for m := 0; m < len(tmp); m++ {
		arr[left+m] = tmp[m]
	}
}
