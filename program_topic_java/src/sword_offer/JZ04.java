package sword_offer;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 示例1
 * 输入
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 返回值
 * {1,2,5,3,4,6,7}
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 因为是树的结构，一般都是用递归来实现。
 * 用数学归纳法的思想就是，假设最后一步，就是root的左右子树都已经重建好了，
 * 那么我只要考虑将root的左右子树安上去即可。
 * 根据前序遍历的性质，第一个元素必然就是root，那么下面的工作就是如何确定root的左右子树的范围。
 * 根据中序遍历的性质，root元素前面都是root的左子树，后面都是root的右子树。
 * 那么我们只要找到中序遍历中root的位置，就可以确定好左右子树的范围。
 * 正如上面所说，只需要将确定的左右子树安到root上即可。递归要注意出口，
 * 假设最后只有一个元素了，那么就要返回。
 */
public class JZ04 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null | pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode tree = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                tree.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                tree.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }

        return tree;
    }
}
