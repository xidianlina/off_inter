package main

import "fmt"

/**
题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）

示例
输入
[1,2,3,4,5],[4,3,5,1,2]
返回值
false
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param pushV int整型一维数组
 * @param popV int整型一维数组
 * @return bool布尔型
 */
func IsPopOrder(pushV []int, popV []int) bool {
	// write code here
	push_len := len(pushV)
	pop_len := len(popV)
	if push_len == 0 || pop_len == 0 || push_len != pop_len {
		return false
	}

	var stk []int
	//stk := make([]int, push_len)
	popIndex := 0
	for i := 0; i < push_len; i++ {
		stk = append(stk, pushV[i])
		for len(stk) != 0 && stk[len(stk)-1] == popV[popIndex] {
			stk = stk[:len(stk)-1]
			popIndex++
		}
	}

	return len(stk) == 0
}

func main() {
	push := []int{1, 2, 3, 4, 5}
	pop1 := []int{4, 5, 3, 2, 1}
	pop2 := []int{4, 3, 5, 1, 2}
	res := IsPopOrder(push, pop1)
	fmt.Println(res)
	fmt.Println("-------------")
	res = IsPopOrder(push, pop2)
	fmt.Println(res)
}
