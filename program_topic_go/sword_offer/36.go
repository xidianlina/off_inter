package main

/**
题目描述
输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
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
func FindFirstCommonNode(head1 *ListNode, head2 *ListNode) *ListNode {
	// write code here
	if head1 == nil || head2 == nil {
		return nil
	}

	var stk1, stk2 []*ListNode
	for head1 != nil {
		stk1 = append(stk1, head1)
		head1 = head1.Next
	}

	for head2 != nil {
		stk2 = append(stk2, head2)
		head2 = head2.Next
	}

	var common_node *ListNode
	for len(stk1) != 0 && len(stk2) != 0 && stk1[len(stk1)-1] == stk2[len(stk2)-1] {
		stk1 = stk1[:len(stk1)-1]
		common_node = stk2[len(stk2)-1]
		stk2 = stk2[:len(stk2)-1]
	}

	return common_node
}

func FindFirstCommonNode2(head1 *ListNode, head2 *ListNode) *ListNode {
	// write code here
	if head1 == nil || head2 == nil {
		return nil
	}

	hash := make(map[*ListNode]*ListNode)
	for head1 != nil {
		hash[head1] = head1
		head1 = head1.Next
	}

	for head2 != nil {
		if _, ok := hash[head2]; ok {
			return head2
		}
		head2 = head2.Next
	}

	return nil
}

func FindFirstCommonNode3(head1 *ListNode, head2 *ListNode) *ListNode {
	// write code here
	if head1 == nil || head2 == nil {
		return nil
	}

	cur := head1
	n := 0
	for cur != nil {
		n++
		cur = cur.Next
	}

	cur = head2
	for cur != nil {
		n--
		cur = cur.Next
	}

	var s, l *ListNode
	if n < 0 {
		s = head1
		l = head2
		n = -n
	} else {
		s = head2
		l = head1
	}

	for i := 0; i < n; i++ {
		l = l.Next
	}

	for s != nil && l != nil && s.Val != l.Val {
		s = s.Next
		l = l.Next
	}

	return l
}
