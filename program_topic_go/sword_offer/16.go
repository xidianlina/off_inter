package main

/**
题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

示例
输入
{8,8,#,9,#,2,#,5},{8,9,#,2}
返回值
true
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
