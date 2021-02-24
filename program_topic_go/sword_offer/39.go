package main

/**
题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
平衡二叉树（Balanced Binary Tree），具有以下性质：
它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
并且左右两个子树都是一棵平衡二叉树。

示例
输入
{1,2,3,4,5,6,7}
返回值
true
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
 * @return bool布尔型
 */
var is_balanced bool

func IsBalanced_Solution(root *TreeNode) bool {
	// write code here
	if root == nil {
		return true
	}
	is_balanced = true

	getDepth(root)
	return is_balanced
}

func getDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	l := getDepth(root.Left)
	r := getDepth(root.Right)
	if r-l > 1 || r-l < -1 {
		is_balanced = false
	}

	if l > r {
		return l + 1
	} else {
		return r + 1
	}
}
