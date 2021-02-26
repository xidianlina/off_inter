package main

/**
题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/
type TreeLinkNode struct {
	Val   int
	Left  *TreeLinkNode
	Right *TreeLinkNode
	Next  *TreeLinkNode
}

func GetNext(root *TreeLinkNode) *TreeLinkNode {
	if root == nil {
		return nil
	}
	if root.Right != nil {
		root = root.Right
		for root.Left != nil {
			root = root.Left
		}
		return root
	}

	for root.Next != nil {
		node := root.Next
		if node.Left == root {
			return node
		}
		root = root.Next
	}
	return nil
}
