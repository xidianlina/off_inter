package main

import "fmt"

/**
题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
*/

/**
栈：栈特点是后进先出，即最后push进的元素最早pop出来。
队列：队列的特点是先进先出，第一个进入队列的元素将第一个出来

使用两个栈串联，可以实现先进先出。但是，得注意以下两点:
队列在入列时，stack2必须为空，stack1满员，保证顺序。
队列在出列时，stack1必须为空，stack2满员
*/
var stack1 []int
var stack2 []int

func Push(node int) {
	stack1 = append(stack1, node)
}

func Pop() int {
	var popped int
	if len(stack1) != 0 && len(stack2) == 0 {
		for len(stack1) != 0 {
			popped = stack1[len(stack1)-1]
			stack2 = append(stack2, popped)
			stack1 = stack1[:len(stack1)-1]
		}
	}
	if len(stack2) != 0 {
		popped = stack2[len(stack2)-1]
		stack2 = stack2[:len(stack2)-1]
	}
	return popped
}

func main() {
	Push(1)
	Push(2)
	Push(3)
	Push(4)
	Push(5)
	fmt.Println(stack1)
	fmt.Println("---------------")
	Pop()
	Pop()
	Pop()
	Pop()
	Pop()
}
