package main

/**
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

示例
输入
{5,4,#,3,#,2,#,1}
返回值
[5,4,3,2,1]
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
 * @param root TreeNode类
 * @return int整型一维数组
 */
func PrintFromTopToBottom(root *TreeNode) []int {
	// write code here
	if root == nil {
		return []int{}
	}

	var res []int
	var que []*TreeNode
	que = append(que, root)
	for len(que) != 0 {
		root = que[0]
		que = que[1:]
		res = append(res, root.Val)
		if root.Left != nil {
			que = append(que, root.Left)
		}
		if root.Right != nil {
			que = append(que, root.Right)
		}
	}

	return res
}
