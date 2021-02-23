package main

import "fmt"

/**
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。

示例
输入
[4,8,6,12,16,14,10]
返回值
true
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param sequence int整型一维数组
 * @return bool布尔型
 */
func VerifySquenceOfBST(arr []int) bool {
	// write code here
	l := len(arr)
	if l == 0 {
		return false
	}
	if l == 1 {
		return true
	}

	return helper(arr, 0, l-1)
}

func helper(arr []int, start, end int) bool {
	if start >= end {
		return true
	}

	i := end
	for i > start && arr[i-1] > arr[end] {
		i--
	}

	for j := start; j < i; j++ {
		if arr[j] > arr[end] {
			return false
		}
	}

	return helper(arr, start, i-1) && helper(arr, i, end-1)
}

func main() {
	arr := []int{4, 8, 6, 12, 16, 14, 10}
	res := VerifySquenceOfBST(arr)
	fmt.Println(res)
}
