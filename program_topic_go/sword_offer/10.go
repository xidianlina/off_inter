package main

import "fmt"

/**
题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

示例
输入
4
返回值
5
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param number int整型
 * @return int整型
 */
func rectCover(n int) int {
	// write code here
	if n <= 2 {
		return n
	}

	return rectCover(n-1) + rectCover(n-2)
}

func rectCover2(n int) int {
	// write code here
	if n <= 1 {
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

func main() {
	res := rectCover(4)
	fmt.Println(res)
	fmt.Println("--------")
	res = rectCover2(4)
	fmt.Println(res)
}
