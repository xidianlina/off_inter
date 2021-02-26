package main

import "fmt"

/**
题目描述
输入一个链表，反转链表后，输出新链表的表头。

示例
输入
{1,2,3}
返回值
{3,2,1}
*/

//type ListNode struct {
//	Val  int
//	Next *ListNode
//}

/**
 *
 * @param pHead ListNode类
 * @return ListNode类
 */
func ReverseList(head *ListNode) *ListNode {
	// write code here
	if head == nil {
		return nil
	}

	root := &ListNode{Val: 0}
	root.Next = head
	start := root.Next
	next := start.Next
	for next != nil {
		start.Next = next.Next
		next.Next = root.Next
		root.Next = next
		next = start.Next
	}

	return root.Next
}

func ReverseList2(head *ListNode) *ListNode {
	// write code here
	if head == nil {
		return nil
	}

	cur := head

	var pre *ListNode
	var next *ListNode

	for cur != nil {
		next = cur.Next
		cur.Next = pre
		pre = cur
		cur = next
	}

	return pre
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

	printList(&head)
	res := ReverseList2(&head)
	printList(res)
	printList(&head)
}

func printList(head *ListNode) {
	if head == nil {
		return
	}

	for head != nil {
		fmt.Print(head.Val)
		head = head.Next
	}
	fmt.Println()
}
