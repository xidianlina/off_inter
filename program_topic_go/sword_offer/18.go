package main

/**
题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。
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
 * @param pRoot TreeNode类
 * @return TreeNode类
 */
func Mirror(root *TreeNode) *TreeNode {
	// write code here
	if root == nil {
		return nil
	}

	stk := make([]*TreeNode, 0)
	stk = append(stk, root)
	for len(stk) != 0 {
		root = stk[len(stk)-1]
		stk = stk[:len(stk)-1]
		if root.Left != nil || root.Right != nil {
			tmp := root.Left
			root.Left = root.Right
			root.Right = tmp
		}

		if root.Left != nil {
			stk = append(stk, root.Left)
		}

		if root.Right != nil {
			stk = append(stk, root.Right)
		}
	}
	return root
}
