package main

import "fmt"

/**
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

示例1
输入
1
返回值
1

示例2
输入
4
返回值
5
*/

/**
 *
 * @param number int整型
 * @return int整型
 */
func jumpFloor(n int) int {
	// write code here
	if n == 1 {
		return n
	}

	tmp := 0
	pre := 1
	res := 1
	for i := 2; i <= n; i++ {
		tmp = res
		res = pre + res
		pre = tmp
	}

	return res
}

func jumpFloor2(n int) int {
	// write code here
	if n <= 2 {
		return n
	}

	return jumpFloor2(n-1) + jumpFloor2(n-2)
}

func main() {
	res := jumpFloor(4)
	fmt.Println(res)
	fmt.Println("-----------")
	res = jumpFloor2(4)
	fmt.Println(res)
}
