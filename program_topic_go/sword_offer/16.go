package main

/**
题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
示例1
输入
{1,3,5},{2,4,6}
返回值
{1,2,3,4,5,6}
*/

/*
 * type ListNode struct{
 *   Val int
 *   Next *ListNode
 * }
 */

/**
 *
 * @param pHead1 ListNode类
 * @param pHead2 ListNode类
 * @return ListNode类
 */
func Merge(list1 *ListNode, list2 *ListNode) *ListNode {
	// write code here
	if list1 == nil {
		return list2
	} else if list2 == nil {
		return list1
	}

	first := new(ListNode)
	first.Val = -1
	cur := first
	for list1 != nil && list2 != nil {
		if list1.Val < list2.Val {
			cur.Next = list1
			list1 = list1.Next
		} else {
			cur.Next = list2
			list2 = list2.Next
		}
		cur = cur.Next
	}

	if list1 != nil {
		cur.Next = list1
	} else if list2 != nil {
		cur.Next = list2
	}

	return first.Next
}
