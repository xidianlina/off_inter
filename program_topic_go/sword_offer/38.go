package main

/**
题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

示例
输入
{1,2,3,4,5,#,6,#,#,7}
返回值
4
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
 * @return int整型
 */
func TreeDepth(root *TreeNode) int {
	// write code here
	if root == nil {
		return 0
	}

	l := TreeDepth(root.Left)
	r := TreeDepth(root.Right)
	if l > r {
		return l + 1
	} else {
		return r + 1
	}
}

func TreeDepth2(root *TreeNode) int {
	// write code here
	if root == nil {
		return 0
	}

	var que []*TreeNode
	que = append(que, root)
	cur_node_cnt, depth := 1, 0
	for len(que) != 0 {
		root = que[0]
		que = que[1:]
		cur_node_cnt--
		if root.Left != nil {
			que = append(que, root.Left)
		}
		if root.Right != nil {
			que = append(que, root.Right)
		}

		if cur_node_cnt == 0 {
			depth++
			cur_node_cnt = len(que)
		}
	}

	return depth
}
