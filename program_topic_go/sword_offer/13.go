package main

import (
	"fmt"
)

/**
题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*/

/**
 *
 * @param array int整型一维数组
 * @return int整型一维数组
 */
func reOrderArray(array []int) []int {
	// write code here
	l := len(array)
	if l == 0 || array == nil {
		return []int{}
	}

	for i := 0; i < l; i++ {
		for j := l - 1; j > i; j-- {
			if array[j]%2 == 1 && array[j-1]%2 == 0 {
				array[j] = array[j] + array[j-1]
				array[j-1] = array[j] - array[j-1]
				array[j] = array[j] - array[j-1]
			}
		}
	}
	return array
}

func reOrderArray2(array []int) []int {
	// write code here
	l := len(array)
	if l == 0 || array == nil {
		return []int{}
	}

	i := 0
	j := 0
	for i < l {
		for i < l && array[i]%2 == 1 {
			i++
		}
		j = i + 1
		for j < l && array[j]%2 == 0 {
			j++
		}
		if j < l {
			tmp := array[j]
			for k := j - 1; k >= i; k-- {
				array[k+1] = array[k]
			}
			array[i] = tmp
		} else {
			break
		}
	}
	return array
}

func main() {
	arr := []int{8, 5, 2, 4, 1, 9}
	fmt.Println(arr)
	res := reOrderArray(arr)
	fmt.Println(res)
	fmt.Println("------------------------")
	res = reOrderArray2(arr)
	fmt.Println(res)
}
