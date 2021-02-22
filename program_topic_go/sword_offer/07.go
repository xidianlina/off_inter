package main

import "fmt"

/**
题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，
请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。39n≤39

示例
输入
4
返回值
3
*/

/**
 *
 * @param n int整型
 * @return int整型
 */
func Fibonacci(n int) int {
	// write code here
	if n <= 1 {
		return n
	}
	return Fibonacci(n-1) + Fibonacci(n-2)
}

func Fib(n int) int {
	// write code here
	if n <= 1 {
		return n
	}

	tmp := 0
	pre := 0
	res := 1
	for i := 2; i <= n; i++ {
		tmp = res
		res = pre + res
		pre = tmp
	}

	return res
}

func main() {
	res := Fibonacci(4)
	fmt.Println(res)
	fmt.Println("--------")
	res = Fib(4)
	fmt.Println(res)
}
