package main

/**
题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
*/

var stack []int
var stackMin []int

func Push(node int) {
	// write code here
	stack = append(stack, node)
	if len(stackMin) == 0 {
		stackMin = append(stackMin, node)
	} else if node < stackMin[len(stackMin)-1] {
		stackMin = append(stackMin, node)
	} else {
		stackMin = append(stackMin, stackMin[len(stackMin)-1])
	}
}
func Pop() {
	// write code here
	stack = stack[:len(stack)-1]
	stackMin = stackMin[:len(stackMin)-1]
}
func Top() int {
	// write code here
	return stack[len(stack)-1]
}
func Min() int {
	// write code here
	return stackMin[len(stackMin)-1]
}
