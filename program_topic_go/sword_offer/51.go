package main

import "fmt"

/**
题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。

示例
输入
[1,2,3,4,5]
返回值
[120,60,40,30,24]
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param A int整型一维数组
 * @return int整型一维数组
 */
func multiply(arr []int) []int {
	// write code here
	l := len(arr)
	if l == 0 || arr == nil {
		return []int{}
	}

	res := make([]int, l)
	res[0] = 1
	for i := 1; i < l; i++ {
		res[i] = res[i-1] * arr[i-1]
	}

	tmp := 1
	for i := l - 2; i >= 0; i-- {
		tmp *= arr[i+1]
		res[i] *= tmp
	}

	return res
}

func main() {
	arr := []int{1, 2, 3, 4, 5}
	res := multiply(arr)
	fmt.Println(res)
}
