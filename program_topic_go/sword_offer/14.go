package main

import "fmt"

/**
题目描述
输入一个链表，输出该链表中倒数第k个结点。

示例
输入
1,{1,2,3,4,5}
返回值
{5}
*/

/**
type ListNode struct {
	Val  int
	Next *ListNode
}
*/

/**
 *
 * @param pListHead ListNode类
 * @param k int整型
 * @return ListNode类
 */
func FindKthToTail(head *ListNode, k int) *ListNode {
	// write code here
	if head == nil || k < 0 {
		return nil
	}

	first := head
	last := head
	for i := 0; i < k; i++ {
		if first != nil {
			first = first.Next
		} else {
			return nil
		}
	}

	for first != nil {
		first = first.Next
		last = last.Next
	}

	return last
}

func main() {
	node4 := ListNode{
		Val:  5,
		Next: nil,
	}
	node3 := ListNode{
		Val:  4,
		Next: &node4,
	}
	node2 := ListNode{
		Val:  3,
		Next: &node3,
	}
	node1 := ListNode{
		Val:  2,
		Next: &node2,
	}
	head := ListNode{
		Val:  1,
		Next: &node1,
	}

	res := FindKthToTail(&head, 1)
	fmt.Println(res)
}
