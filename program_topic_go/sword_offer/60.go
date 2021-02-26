package main

/**
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

示例
输入
{8,6,10,5,7,9,11}
返回值
[[8],[6,10],[5,7,9,11]]
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
 * @return int整型二维数组
 */
func Print(root *TreeNode) [][]int {
	// write code here
	if root == nil {
		return [][]int{}
	}

	var res [][]int
	var tmp []int
	var que []*TreeNode
	node_count := 1
	que = append(que, root)
	for len(que) > 0 {
		root = que[0]
		que = que[1:]
		node_count--
		if root.Left != nil {
			que = append(que, root.Left)
		}
		if root.Right != nil {
			que = append(que, root.Right)
		}
		tmp = append(tmp, root.Val)
		if node_count == 0 {
			node_count = len(que)
			res = append(res, tmp)
			tmp = []int{}
		}
	}

	return res
}
