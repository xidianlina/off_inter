package main

/**
题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

示例
输入
{8,6,10,5,7,9,11}
返回值
[[8],[10,6],[5,7,9,11]]
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
	left_to_right := true
	que = append(que, root)
	node_count := 1
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
			if left_to_right {
				res = append(res, tmp)
			} else {
				for i, j := 0, len(tmp)-1; i < j; i, j = i+1, j-1 {
					tmp[i], tmp[j] = tmp[j], tmp[i]
				}
				res = append(res, tmp)
			}
			left_to_right = !left_to_right
			tmp = []int{}
		}
	}

	return res
}
