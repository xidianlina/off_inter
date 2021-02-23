package main

/**
题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

示例
输入
[4,5,1,6,2,7,3,8],4
返回值
[1,2,3,4]
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param input int整型一维数组
 * @param k int整型
 * @return int整型一维数组
 */
func GetLeastNumbers_Solution(input []int, k int) []int {
	// write code here
	l := len(input)
	if l == 0 || input == nil || l < k || k <= 0 {
		return []int{}
	}

	start, end := 0, l-1
	index := partition(input, start, end)
	for index != k-1 {
		if index > k-1 {
			end = index - 1
		} else if index < k-1 {
			start = index + 1
		}
		index = partition(input, start, end)
	}

	return input[:k]
}
