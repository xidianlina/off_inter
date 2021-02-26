package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func EntryNodeOfLoop(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}

	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			fast = head
			for slow != fast {
				slow = slow.Next
				fast = fast.Next
			}
			return slow
		}
	}
	return nil
}

func EntryNodeOfLoop2(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}

	m := make(map[*ListNode]bool, 0)
	node := head
	for node != nil {
		if _, ok := m[node]; ok {
			return node
		} else {
			m[node] = true
			node = node.Next
		}
	}
	return nil
}
