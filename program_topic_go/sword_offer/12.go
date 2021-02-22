package main

import "fmt"

/**
题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0

示例
输入
2,3
返回值
8.00000
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param base double浮点型
 * @param exponent int整型
 * @return double浮点型
 */
func Power(base float64, exponent int) float64 {
	// write code here
	var res float64
	if exponent == 0 {
		return 1
	} else if exponent > 0 {
		res = base
		for i := 1; i < exponent; i++ {
			res *= base
		}
		return res
	} else {
		res = base
		flag := -exponent
		for i := 1; i < flag; i++ {
			res *= base
		}
		return 1 / res
	}
}

func main() {
	res := Power(2, 3)
	fmt.Println(res)
}
