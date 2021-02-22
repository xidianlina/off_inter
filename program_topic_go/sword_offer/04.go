package main

/**
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

示例
输入
[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
返回值
{1,2,5,3,4,6,7}
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param pre int整型一维数组
 * @param vin int整型一维数组
 * @return TreeNode类
 */

/**
因为是树的结构，一般都是用递归来实现。
用数学归纳法的思想就是，假设最后一步，就是root的左右子树都已经重建好了，
那么我只要考虑将root的左右子树安上去即可。
根据前序遍历的性质，第一个元素必然就是root，那么下面的工作就是如何确定root的左右子树的范围。
根据中序遍历的性质，root元素前面都是root的左子树，后面都是root的右子树。
那么我们只要找到中序遍历中root的位置，就可以确定好左右子树的范围。
正如上面所说，只需要将确定的左右子树安到root上即可。递归要注意出口，
假设最后只有一个元素了，那么就要返回。
*/
func reConstructBinaryTree(pre []int, vin []int) *TreeNode {
	// write code here
	if pre == nil || len(pre) == 0 || vin == nil || len(vin) == 0 || len(pre) != len(vin) {
		return nil
	}

	// 第一步，构建root节点
	var root = new(TreeNode)
	root.Val = pre[0]

	// 第二步，找到左子树数组
	var index int // 代表中序遍历左子树数组最右侧索引，也代表左子树节点数量
	for i := 0; i < len(vin); i++ {
		if vin[i] == root.Val {
			index = i
			break
		}
	}

	// 递归计算其左子树和右子树
	root.Left = reConstructBinaryTree(pre[1:index+1], vin[:index])
	root.Right = reConstructBinaryTree(pre[index+1:], vin[index+1:])

	return root
}
