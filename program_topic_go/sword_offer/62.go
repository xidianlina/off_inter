package main

/**
题目描述
给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。

示例
输入
{5,3,7,2,4,6,8},3
返回值
{4}
说明
按结点数值大小顺序第三小结点的值为4
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
 * @param k int整型
 * @return TreeNode类
 */
func KthNode(root *TreeNode, k int) *TreeNode {
	// write code here
	if root == nil || k <= 0 {
		return nil
	}

	var stk []*TreeNode
	for len(stk) > 0 || root != nil {
		if root != nil {
			stk = append(stk, root)
			root = root.Left
		} else {
			root = stk[len(stk)-1]
			stk = stk[:len(stk)-1]
			if k == 1 {
				return root
			}
			k--
			root = root.Right
		}
	}
	return nil
}
