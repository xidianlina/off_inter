package main

import "fmt"

/**
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
求该青蛙跳上一个n级的台阶总共有多少种跳法。

示例
输入
3
返回值
4
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param number int整型
 * @return int整型
 */
func jumpFloorII(n int) int {
	// write code here
	if n <= 1 {
		return 1
	}

	res := 1
	for i := 1; i < n; i++ {
		res += jumpFloorII(n - i)
	}
	return res
}

func main() {
	res := jumpFloorII(3)
	fmt.Println(res)
}
