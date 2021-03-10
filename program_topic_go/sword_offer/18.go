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

	root.Left, root.Right = root.Right, root.Left
	Mirror(root.Left)
	Mirror(root.Right)
	return root
}
