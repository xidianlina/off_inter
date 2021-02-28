package main

import (
	"strconv"
	"strings"
)

/**
题目描述
请实现两个函数，分别用来序列化和反序列化二叉树
二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
序列化的结果是一个字符串，序列化时通过某种符号表示空节点（#），以!表示一个结点值的结束（value!）。
二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树

示例
输入
{8,6,10,5,7,9,11}
返回值
{8,6,10,5,7,9,11}
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
 * @return TreeNode类
 */
func Serialize(root *TreeNode) string {
	// write code here
	var res []string
	if root == nil {
		res = append(res, "#,")
		return strings.Join(res, "")
	}

	res = append(res, strconv.Itoa(root.Val)+",")
	res = append(res, Serialize(root.Left))
	res = append(res, Serialize(root.Right))
	return strings.Join(res, "")
}

var index int = -1

func Deserialize(str string) *TreeNode {
	index++
	l := len(str)
	if l <= 0 {
		return nil
	}

	var node *TreeNode
	str_arr := strings.Split(str, ",")
	if str_arr[index] != "#" {
		val, _ := strconv.Atoi(str_arr[index])
		node = &TreeNode{
			Val:   val,
			Left:  Deserialize(str),
			Right: Deserialize(str),
		}
	}
	return node
}
