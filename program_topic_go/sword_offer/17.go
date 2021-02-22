package main

/**
题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

示例
输入
{8,8,#,9,#,2,#,5},{8,9,#,2}
返回值
true
*/

/**
type TreeNode struct {
  Val int
 Left *TreeNode
  Right *TreeNode
 }
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param pRoot1 TreeNode类
 * @param pRoot2 TreeNode类
 * @return bool布尔型
 */
func HasSubtree(root1 *TreeNode, root2 *TreeNode) bool {
	// write code here
	if root1 == nil || root2 == nil {
		return false
	}

	return isSubtree(root1, root2) || isSubtree(root1.Left, root2) || isSubtree(root1.Right, root2)
}

func isSubtree(f *TreeNode, c *TreeNode) bool {
	if c == nil {
		return true
	}

	if f == nil || f.Val != c.Val {
		return false
	}

	return isSubtree(f.Left, c.Left) && isSubtree(f.Right, c.Right)
}
