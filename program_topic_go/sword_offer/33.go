package main

import "fmt"

/**
题目描述
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

示例
输入
7
返回值
8
*/

/**
 *
 * @param index int整型
 * @return int整型
 */
func GetUglyNumber_Solution(index int) int {
	// write code here
	if index <= 1 {
		return index
	}

	res := make([]int, index)
	res[0] = 1
	t2, t3, t5 := 0, 0, 0
	for i := 1; i < index; i++ {
		res[i] = find_min(res[t2]*2, res[t3]*3, res[t5]*5)
		if res[i] == res[t2]*2 {
			t2++
		}

		if res[i] == res[t3]*3 {
			t3++
		}

		if res[i] == res[t5]*5 {
			t5++
		}
	}

	return res[index-1]
}

func find_min(i, j, k int) int {
	min := i
	if j < min {
		min = j
	}
	if k < min {
		min = k
	}
	return min
}

func main() {
	res := GetUglyNumber_Solution(7)
	fmt.Println(res)
}
