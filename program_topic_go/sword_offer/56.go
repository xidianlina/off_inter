package main

/**
题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

示例1
输入
{1,2,3,3,4,4,5}
返回值
{1,2,5}
*/

/*
 * type ListNode struct{
 *   Val int
 *   Next *ListNode
 * }
 */

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param pHead ListNode类
 * @return ListNode类
 */
func deleteDuplication(head *ListNode) *ListNode {
	// write code here
	if head == nil {
		return nil
	}
	if head != nil && head.Next == nil {
		return head
	}

	if head.Val == head.Next.Val {
		cur := head.Next.Next
		for cur != nil && cur.Val == head.Val {
			cur = cur.Next
		}
		return deleteDuplication(cur)
	} else {
		cur := head.Next
		head.Next = deleteDuplication(cur)
		return head
	}
}

func deleteDuplication2(head *ListNode) *ListNode {
	// write code here
	if head == nil {
		return nil
	}
	if head != nil && head.Next == nil {
		return head
	}

	first := new(ListNode)
	first.Val = -1
	first.Next = head
	last, p := first, head
	for p != nil && p.Next != nil {
		if p.Val == p.Next.Val {
			val := p.Val
			for p != nil && p.Val == val {
				p = p.Next
			}
			last.Next = p
		} else {
			last = p
			p = p.Next
		}
	}

	return first.Next
}
