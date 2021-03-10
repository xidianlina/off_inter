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
  方法一 递归
  先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，
  当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像。
*/
func Mirror(root *TreeNode) *TreeNode {
	// write code here
	if root == nil {
		return nil
	}

	if root.Left == nil && root.Right == nil {
		return root
	}

	root.Left, root.Right = root.Right, root.Left

	if root.Left != nil {
		Mirror(root.Left)
	}

	if root.Right != nil {
		Mirror(root.Right)
	}
	return root
}

/**
  方法二 非递归
  思路类似于之前的求二叉树高度，以广度优先的方式进行查找。首先查找出每一层的节点，
  接着对每一层节点的子节点进行镜像，也就是交换操作。全部完成后即镜像完毕。
*/
func Mirror2(root *TreeNode) *TreeNode {
	// write code here
	if root == nil {
		return nil
	}

	stk := make([]*TreeNode, 0)
	stk = append(stk, root)
	count := 1
	for len(stk) != 0 {
		root = stk[len(stk)-1]
		stk = stk[:len(stk)-1]
		count--
		if root.Left != nil || root.Right != nil {
			root.Left, root.Right = root.Right, root.Left
			if root.Left != nil {
				stk = append(stk, root.Left)
			}

			if root.Right != nil {
				stk = append(stk, root.Right)
			}
		}

		if count == 0 {
			count = len(stk)
		}
	}
	return root
}
