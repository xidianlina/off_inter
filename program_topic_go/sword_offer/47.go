package main

/**
题目描述
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

示例
输入
5
返回值
15
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param n int整型
 * @return int整型
 */
func Sum_Solution(n int) int {
	// write code here
	if n == 0 {
		return 0
	}

	return n + Sum_Solution(n-1)
}

var res int

func Sum_Solution2(n int) int {
	// write code here
	res = 0
	sum_helper(n)

	return res
}

func sum_helper(n int) bool {
	res += n
	return n > 0 && (sum_helper(n - 1))
}
