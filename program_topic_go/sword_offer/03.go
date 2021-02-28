package main

import (
	"fmt"
)

/**
题目描述
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

示例1
输入
{67,0,24,58}
返回值
[58,24,0,67]
*/

//type ListNode struct {
//	Val  int
//	Next *ListNode
//}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param head ListNode类
 * @return int整型一维数组
 */
func printListFromTailToHead(head *ListNode) []int {
	// write code here
	if head == nil {
		return []int{}
	}

	var stk []*ListNode
	for head != nil {
		stk = append(stk, head)
		head = head.Next
	}

	var res []int
	for len(stk) > 0 {
		res = append(res, stk[len(stk)-1].Val)
		stk = stk[:len(stk)-1]
	}
	return res
}

func printListFromTailToHead2(head *ListNode) []int {
	// write code here
	p := head //工作指针
	n := 0

	//统计节点数目
	for p != nil {
		n++
		p = p.Next
	}

	p = head              //工作指针复位
	arr := make([]int, n) // 开辟切片空间
	//第二次遍历链表,存入数组
	for i := n - 1; i >= 0; i-- {
		arr[i] = p.Val
		p = p.Next
	}
	return arr
}

func printListFromTailToHead3(head *ListNode) []int {
	// write code here
	if head == nil {
		return []int{}
	}
	return append(printListFromTailToHead3(head.Next), head.Val)
}

func main() {
	node4 := ListNode{
		Val:  4,
		Next: nil,
	}
	node3 := ListNode{
		Val:  3,
		Next: &node4,
	}
	node2 := ListNode{
		Val:  2,
		Next: &node3,
	}
	node1 := ListNode{
		Val:  1,
		Next: &node2,
	}
	head := ListNode{
		Val:  0,
		Next: &node1,
	}

	res := printListFromTailToHead(&head)
	fmt.Println(res)

	arr := printListFromTailToHead2(&head)
	fmt.Println(arr)

	arr = printListFromTailToHead3(&head)
	fmt.Println(arr)
}
