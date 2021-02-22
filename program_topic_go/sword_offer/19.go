package main

import "fmt"

/**
题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

示例
输入
[[1,2],[3,4]]
返回值
[1,2,4,3]
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param matrix int整型二维数组
 * @return int整型一维数组
 */
func printMatrix(matrix [][]int) []int {
	// write code here
	row := len(matrix)
	col := len(matrix[0])
	if matrix == nil || row == 0 || col == 0 {
		return []int{}
	}

	top := 0
	bottom := row - 1
	left := 0
	right := col - 1
	var res []int
	//螺旋曲线，运动轨迹总是一致的
	for top <= bottom && left <= right {
		//向右列递增遍历
		for j := left; j <= right; j++ {
			res = append(res, matrix[top][j])
		}

		//遍历后，去掉此行
		top++

		//向下行递增遍历
		for i := top; i <= bottom; i++ {
			res = append(res, matrix[i][right])
		}

		//遍历后，去掉此列
		right--

		if top <= bottom { //重要判断，防止重复
			//向左列递减遍历
			for j := right; j >= left; j-- {
				res = append(res, matrix[bottom][j])
			}
		}

		//遍历后，去掉此行
		bottom--

		if left <= right { //重要判断，防止重复
			//向上行递减遍历
			for i := bottom; i >= top; i-- {
				res = append(res, matrix[i][left])
			}
		}

		//遍历后，去掉此列
		left++
	}

	return res
}

func main() {
	arr := [][]int{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
	res := printMatrix(arr)
	fmt.Println(res)
}
