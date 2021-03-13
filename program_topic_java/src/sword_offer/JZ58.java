package sword_offer;

/**
 * 题目描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 示例1
 * 输入
 * {8,6,6,5,7,7,5}
 * 返回值
 * true
 * 示例2
 * 输入
 * {8,6,9,5,7,7,5}
 * 返回值
 * false
 */
public class JZ58 {
    boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
