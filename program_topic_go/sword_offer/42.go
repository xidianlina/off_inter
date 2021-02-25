package main

import "fmt"

/**
题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

返回值描述:
对应每个测试案例，输出两个数，小的先输出。

示例
输入
[1,2,4,7,11,15],15
返回值
[4,11]
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param array int整型一维数组
 * @param sum int整型
 * @return int整型一维数组
 */
func FindNumbersWithSum(array []int, sum int) []int {
	// write code here
	l := len(array)
	if l < 2 || array == nil {
		return []int{}
	}

	var res []int
	i, j := 0, l-1
	for i < j {
		if array[i]+array[j] == sum {
			res = append(res, array[i])
			res = append(res, array[j])
			return res
		} else if array[i]+array[j] > sum {
			j--
		} else {
			i++
		}
	}

	return res
}

func FindNumbersWithSum2(array []int, sum int) []int {
	// write code here
	l := len(array)
	if l < 2 || array == nil {
		return []int{}
	}

	var res []int

	for i := 0; i < l; i++ {
		for j := i; j < l; j++ {
			if array[i]+array[j] == sum {
				res = append(res, array[i])
				res = append(res, array[j])
				return res
			}
		}
	}

	return res
}

func main() {
	arr := []int{1, 2, 4, 7, 11, 15}
	sum := 15
	res := FindNumbersWithSum(arr, sum)
	fmt.Println(res)
	fmt.Println("-------------")
	res = FindNumbersWithSum2(arr, sum)
	fmt.Println(res)
}
