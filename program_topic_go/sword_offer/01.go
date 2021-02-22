package main

import "fmt"

/**
题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。

示例1
输入
7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
返回值
true
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param target int整型
 * @param array int整型二维数组
 * @return bool布尔型
 */
func Find(target int, array [][]int) bool {
	// write code here
	r := len(array)
	c := len(array[0])
	i := 0
	j := c - 1
	for {
		if i >= r || j < 0 {
			break
		}
		if target > array[i][j] {
			i++
		} else if target < array[i][j] {
			j--
		} else {
			return true
		}
	}
	return false
}

func main() {
	target := 7
	array := [][]int{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}
	res := Find(target, array)
	fmt.Println(res)

	target = 70
	var arr = [][]int{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}
	res = Find(target, arr)
	fmt.Println(res)
}
