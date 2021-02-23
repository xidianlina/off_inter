package main

/**
题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/

/*
 * type TreeNode struct {
 *   Val int
 *   Left *TreeNode
 *   Right *TreeNode
 * }
 */

/**
 *
 * @param pRootOfTree TreeNode类
 * @return TreeNode类
 */

/**
解析：在二叉搜索树中，每个结点都有两个分别指向其左、右子树的指针，左子树结点的值总是小于父结点的值，
右子树结点的值总是大于父结点的值。在双向链表中，每个结点也有两个指针，它们分别指向前一个结点和后一个结点。
所以这两种数据结构的结点是一致，二叉搜索树和双向链表只是因为两个指针的指向不同而已，通过改变其指针的指向来实现是完全可能的。
为了减少指针的变换次数，并让操作更加简单，在转换成排序双向链表时，原先指向左子结点的指针调整为链表中指向前一个结点的指针，
原先指向右子结点的指针调整为链表中指向下一个结点的指针。由于要求链表是有序的，可以借助二叉树中序遍历，
因为中序遍历算法的特点就是从小到大访问结点。当遍历访问到根结点时，假设根结点的左侧已经处理好，
只需将根结点与上次访问的最近结点（左子树中最大值结点）的指针连接好即可。进而更新当前链表的最后一个结点指针。
同时中序遍历过程正好是转换成链表的过程，可采用递归方法处理。
*/
func Convert(root *TreeNode) *TreeNode {
	// write code here
	if root == nil || root.Left == nil && root.Right == nil {
		return root
	}

	var stk []*TreeNode
	var node *TreeNode
	for root != nil || len(stk) != 0 {
		if root != nil {
			stk = append(stk, root)
			root = root.Right
		} else {
			root = stk[len(stk)-1]
			stk = stk[:len(stk)-1]
			if node == nil {
				node = root
			} else {
				node.Left = root
				root.Right = node
				node = root
			}
			root = root.Left
		}
	}
	return node
}
