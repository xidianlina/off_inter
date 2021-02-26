package main

/**
题目描述
请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

示例1
输入
{8,6,6,5,7,7,5}
返回值
true

示例2
输入
{8,6,9,5,7,7,5}
返回值
false
*/

/*
 * type TreeNode struct {
 *   Val int
 *   Left *TreeNode
 *   Right *TreeNode
 * }
 */

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param pRoot TreeNode类
 * @return bool布尔型
 */
func isSymmetrical(root *TreeNode) bool {
	// write code here
	if root == nil {
		return true
	}

	return symmetrical_helper(root.Left, root.Right)
}

func symmetrical_helper(left, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	}

	if left == nil || right == nil {
		return false
	}

	if left.Val != right.Val {
		return false
	}

	return symmetrical_helper(left.Left, right.Right) && symmetrical_helper(left.Right, right.Left)
}
